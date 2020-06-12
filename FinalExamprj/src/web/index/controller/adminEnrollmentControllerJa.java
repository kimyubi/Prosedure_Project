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

@WebServlet("/adminenrollmentJa")
public class adminEnrollmentControllerJa extends HttpServlet {

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
		list = service.lectureListJa(field, search);

		request.setAttribute("list", list);

		//검색 기능

		request.getRequestDispatcher("/adminenrollmentJa.jsp").forward(request, response);
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
		String code = null ;
		if(code_!=null&&!code_.equals(""))
		{
			code= code_;
		}
	
		int result2= service.deleteLectureDetail(code);
		int result3 = service.deleteWeeklyProgress(code);
		int result1 = service.deleteLecture(code);
	
	
		if(result1==1&& result2==1 &&result3==1)
		{
			out.println("<script>alert('해당 강의가 성공적으로 삭제되었습니다.');</script>");
			out.println("<script>location.href='/adminenrollmentJa'</script>");
		}
		else if( result1 ==1)//강의 계획서가 등록되어 있지 않은 경우
		{
			out.println("<script>alert('해당 강의가 성공적으로 삭제되었습니다.');</script>");
			out.println("<script>location.href='/adminenrollmentJa'</script>");
		}
	
	
		
	}
}
