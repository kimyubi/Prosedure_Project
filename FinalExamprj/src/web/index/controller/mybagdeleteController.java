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

@WebServlet("/mybagdelete")
public class mybagdeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnrollmentService service = new EnrollmentService();
		List<EnrollmentList> MiridamgiList = new ArrayList<EnrollmentList>();
		String id = (String) request.getSession().getAttribute("Signedid");
		MiridamgiList  =service.showMiridamgiList(id);
		int totalmiriGrades = 0;
		String totalGrades_= service.totalMiriGrades(id);
		if(totalGrades_!=null&&!totalGrades_.equals(""))
		{
			totalmiriGrades =Integer.parseInt(totalGrades_);
		}
		
		request.setAttribute("totalmiriGrades", totalmiriGrades);
		
  	 request.setAttribute("list", MiridamgiList);
  	 
  	 
	  request.getRequestDispatcher("/mybagdelete.jsp").forward(request, response);
		
	
}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String code = request.getParameter("code");
		String id = (String) request.getSession().getAttribute("Signedid");
		//현재 로그인 중인(세션에 저장되어 있는) 아이디와 삭제를 선택한 강좌의 코드를 각각 id와 code에 저장
		
		//id와 code를 매개변수로 넘겨주면 id와 code정보를 가지고 데이터베이스의 enrollment테이블의 행 삭제하는 서비스 함수 호출
		DeleteLectureService service = new DeleteLectureService();
		int result = service.deleteMyBag(id, code);
		if(result ==1)
		{
			out.println("<script>alert('선택하신 강좌가 삭제되었습니다. ' );</script>");
    		out.println("<script>location.href='/mybagdelete'</script>");
		}
		
	}
	
	
    
}
