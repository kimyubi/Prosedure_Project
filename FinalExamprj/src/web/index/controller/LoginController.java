package web.index.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//인코딩 UTF-8
		
	    HttpSession session = request.getSession();
		LoginService service = new LoginService();
		//현재 로그인 한 사용자의 아이디를 저장하기 위해 session 객체 생성
		
		String id = request.getParameter("loginid");
		String password = request.getParameter("loginpassword");
		//login.jsp에서 사용자가 입력한 id와 password의 파라미터 값을 가져옴
		
		PrintWriter out = response.getWriter();
		
		int islogin = service.logIn(id, password);
		//사용자로부터 넘겨 받은 아이디와 비밀번호를  데이터베이스의 PERSONALINFO 테이블에 있는 회원 정보와 비교한다.
		// islogin ==1  > 넘겨받은 아이디와 비밀번호가 PERSONALINFO테이블에 저장되어있는 회원 정보와 일치
		// islogin ==2  > 넘겨받은 아이디는 PERSONALINFO에 저장되어있는 아이디와 동일하지만 비밀번호가 다름
		// islogin ==3  > PERSONALINFO에 넘겨받은 아이디로 저장되어있는 PERSONALINFO가 없음
		
	  // request.getSession().setAttribute("islogin", islogin);
	    
	    if(islogin==1)//로그인 성공
	    {
	    	if(id.equals("admin")&&password.equals("admin"))//아이디와 비밀번호를 admin, admin으로 입력했을 때
	    	{
	    		session.setAttribute("adminid", id);    //adminid라는 이름으로 세션에 저장
	    		session.setMaxInactiveInterval(30*60); //세션 유지기간 : 30분
	    		out.println("<script>alert('관리자 로그인 성공, 관리자 페이지로 이동합니다.');</script>");
	    		out.println("<script>location.href='/adminindex.jsp'</script>");
	    	}
	    	
	    	else 
	    	{
	    	session.setAttribute("Signedid", id);
	    	session.setMaxInactiveInterval(30*60);
	    	
	    	out.println("<script>alert('로그인에 성공하셨습니다.');</script>");
	    	out.println("<script>location.href='/welcomeindex.jsp'</script>");
	    	}
	    	
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
	    
	
	}
	

}
