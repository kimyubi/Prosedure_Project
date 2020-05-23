package web.index.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.RequestContext;

import web.index.Service.JoinService;
import web.index.entity.personalinfo;


@WebServlet("/join")
public class JoinController extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");


		JoinService joinserv= new JoinService();

		String name = req.getParameter("name");
		String nickname =req.getParameter("nickname");
		String id = req.getParameter("id");
	    String password=	req.getParameter("password");
		String email= req.getParameter("email");
	    String tel=	req.getParameter("tel");
	    personalinfo person = new personalinfo(id,password,nickname,email,tel,name);
    	 joinserv.registerAccount(person);
    	
    	 resp.sendRedirect("/login.jsp");
  

	   
	
	}
	
	

}
