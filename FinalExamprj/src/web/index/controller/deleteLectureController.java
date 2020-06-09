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

import web.index.Service.DeleteLectureService;
import web.index.Service.EnrollmentService;
import web.index.entity.EnrollmentList;
import web.index.entity.Lecture;

@WebServlet("/deleteLecture")
public class deleteLectureController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnrollmentService service = new EnrollmentService();
		List<EnrollmentList> list = new ArrayList<EnrollmentList>();
		String id = (String) request.getSession().getAttribute("Signedid");
		list  =service.showEnrollmentList(id);
  	   request.setAttribute("list", list);
	 //로그인 한 사용자의 수강신청 목록을 보여줌.
		request.getRequestDispatcher("/deleteLecture.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String code = request.getParameter("code");
		String id = (String) request.getSession().getAttribute("Signedid");
		//현재 로그인 중인(세션에 저장되어 있는) 사용자의 아이디와 삭제할 강좌의 코드를 각각 id와 code에 저장
		
		//id와 code를 매개변수로 넘겨주면 id와 code정보를 가지고 데이터베이스의 enrollment테이블의 행 삭제하는 서비스 함수 호출
		DeleteLectureService service = new DeleteLectureService();
		int result = service.delete(id, code);
		if(result ==1)
		{
			out.println("<script>alert('선택하신 강좌가 삭제되었습니다. ' );</script>");
    		out.println("<script>location.href='/deleteLecture'</script>");
		}
		
	}
	
	
    
}
