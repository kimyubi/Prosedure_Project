package web.index.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index.Service.EnrollmentService;
import web.index.entity.Lecture;

@WebServlet("/adminenrollment")
public class adminEnrollmentCotroller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EnrollmentService service = new EnrollmentService();
		List<Lecture> list = new ArrayList<Lecture>();
		//강의 목록을 담기 위한 리스트.
	

		String field = "code"; 
		String field_ = request.getParameter("selection");
		if (field_ != null && !field_.equals(" ")) {
			field = field_;
		}
		//field의 기본 값은 "code"로 하고 "selection"의 파라미터 값이 null이 아니고, ""도 아니라면 
		//field에 파라미터 값을 저장한다.

		String search = "";
		String search_ = request.getParameter("search");
		if (search_ != null && !search_.equals("")) {
			search = search_;
		}
		//search의 기본 값은 ""로 하고 "search"의 파라미터 값이 null이 아니고, ""도 아니라면 
    	//search에 파라미터 값을 저장한다.
		
		list = service.lectureList(field, search);
		// field와 search로 조건을 제한한 결과를 가져온다.

		request.setAttribute("list", list);
		//검색 기능
		request.getRequestDispatcher("/adminenrollment.jsp").forward(request, response);
		// /adminenrollment.jsp와 request객체를 공유해 /adminenrollment.jsp 페이지에서 request객체에 저장되어 있는 값(list)을 사용할 수 있다. 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//인코딩 UTF-8로 설정
		
		PrintWriter out = response.getWriter();
		
		EnrollmentService service = new EnrollmentService();
		String code_ = request.getParameter("code");
		// adminenrollment.jsp로부터 "code"의 파라미터 값을 가져온다.
		String code = null ;
		if(code_!=null&&!code_.equals(""))
		{
			code= code_;
		}
		int result1= service.deleteLectureDetail(code);
		//해당 과목코드를 가진 강의의 상세정보를 DELETE한다.
		// ->LECTUREDETAIL 테이블에서 과목코드가 code인 행을 delete한다.
		
		int result2 = service.deleteWeeklyProgress(code);
		//해당 과목코드를 가진 강의의 주차별 계획서를 DELETE한다.
		// ->WEEKLYPROGRESS 테이블에서 과목코드가 code인 행을 delete한다.
		
		int result3 = service.deleteLecture(code);
		//해당 과목코드를 가진 강의를 DELETE한다.
		// ->LECTURE 테이블에서 과목코드가 code인 행을 delete한다.
	
	
		if(result3==1)
		{
			out.println("<script>alert('해당 강의가 성공적으로 삭제되었습니다.');</script>");
			out.println("<script>location.href='/adminenrollment'</script>");
		}
		else 
		{
			out.println("<script>alert('오류로 인해 삭제에 실패했습니다.');</script>");
			out.println("<script>location.href='/adminenrollment'</script>");
		}
	
	
		
	}
}
