package web.index.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index.Service.EnrollmentService;
import web.index.entity.EnrollmentList;

@WebServlet("/mypage")
public class MypageController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnrollmentService service = new EnrollmentService();
		List<EnrollmentList> list = new ArrayList<EnrollmentList>();
		String id = (String) request.getSession().getAttribute("Signedid");
		list  =service.showEnrollmentList(id);
		String totalGrades = service.totalGrades(id);
		
  	 request.setAttribute("list", list);
  	 request.setAttribute("totalGrades", totalGrades);
	  request.getRequestDispatcher("/mypage.jsp").forward(request, response);
		
		
	}

}
