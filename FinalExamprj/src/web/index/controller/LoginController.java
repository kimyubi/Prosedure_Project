package web.index.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.index.Service.LoginService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	     HttpSession session = req.getSession();
		LoginService service = new LoginService();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String id = req.getParameter("loginid");
		String password = req.getParameter("loginpassword");
		PrintWriter out = resp.getWriter();
		int islogin = service.logIn(id, password);
	    req.setAttribute("islogin", islogin);
	    if(islogin==1)
	    {
	    	session.setAttribute("Signedid", id);
	    	session.setMaxInactiveInterval(30*60);
	    	
	    	out.println("<script>alert('로그인에 성공하셨습니다.');</script>");
	    	out.println("<script>location.href='/welcomeindex.jsp'</script>");
	    }
	    else if(islogin==2)
	    {
	    	out.println("<script>alert('비밀번호를 잘못 입력하셨습니다. 올바른 비밀번호를 입력해주세요.');</script>");
	    	out.println("<script>location.href='/login.jsp'</script>");
	    
	    }
	    else if(islogin ==3)
	    {
	    	out.println("<script>alert('없는 계정입니다. 회원가입을 먼저 진행해주세요.');</script>");
	    	out.println("<script>location.href='/join.jsp'</script>");
	    }
	    
	    
//	       RequestDispatcher   dispatcher= req.getRequestDispatcher("/login.jsp");
//           dispatcher.forward(req, resp);	
		
		
		
	}
	

}
