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
import web.index.entity.Lecture;

@WebServlet("/enrollment")
public class EnrollmentCotroller extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EnrollmentService service = new EnrollmentService();
		List<Lecture> list = new ArrayList<Lecture>();
		
	   String field ="code";
	   String field_ = request.getParameter("selection");
	    if(field_!=null&&!field_.equals(" "))
	   {
		 field = field_;		   
		  }
		
	   String search="";
	   String search_ = request.getParameter("search");
	   if(search_!=null&&!search_.equals(""))
	   {
		   search  = search_;
	   }
		list = service.lectureList(field,search);
		  request.setAttribute("list", list);
		  
		

		request.getRequestDispatcher("/enrollment.jsp").forward(request, response);
		
		
	}
}

