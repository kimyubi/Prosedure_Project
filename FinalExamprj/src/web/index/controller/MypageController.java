package web.index.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.i;
import web.index.Service.EnrollmentService;
import web.index.entity.EnrollmentList;

@WebServlet("/mypage")
public class MypageController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnrollmentService service = new EnrollmentService();
		List<EnrollmentList> list = new ArrayList<EnrollmentList>();
	    //EnrollmenrtList: 강의 목록을 담는 entity
		
		String id = (String) request.getSession().getAttribute("Signedid");
		//현재 로그인 중인 사용자의 수강신청 목록을 가져오기 위해서
		
		list  =service.showEnrollmentList(id);
		//현재 로그인 중인 사용자의 아이디를 매개변수로 주고 해당 사용자의 수강신청 목록을 가져온다.
		
		int totalGrades = 0;
		String totalGrades_=service.totalGrades(id);
		if(totalGrades_!=null&&!totalGrades_.equals(""))
		{
			totalGrades= Integer.parseInt(totalGrades_);
		}
		
  	 request.setAttribute("list", list);
  	 request.setAttribute("totalGrades", totalGrades);
  	 
  	 
	  request.getRequestDispatcher("/mypage.jsp").forward(request, response);
	
	
		
	}

}
