package web.index.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import web.index.Service.LoginService;
import web.index.Service.MyInfoService;
import web.index.entity.personalinfo;

@WebServlet("/myinfo")
public class MyInfoController extends HttpServlet {
	
     @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
     {
 		request.setCharacterEncoding("UTF-8");
 		response.setCharacterEncoding("UTF-8");
 		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
    	 MyInfoService service  = new MyInfoService();
    	 personalinfo myinfo = null;
    	String id =  (String) request.getSession().getAttribute("Signedid");
    	myinfo = service.getInfo(id);
    	request.setAttribute("myinfo", myinfo);
    	String colleage = request.getParameter("select");
      
    	int result = service.setInfo(id, colleage);
    	if(result==1)
    	{
    	 	out.println("<script>alert('저장되었습니다.');</script>");
	    	out.println("<script>location.href='/myinfo'</script>");
    	String maxgrades =	service.myMaxGrades(id);
        request.getSession().setAttribute("maxgrades", Integer.parseInt(maxgrades));
        
    	}
    	
    	
    	

    	
    	
    	request.getRequestDispatcher("/MyInfo.jsp").forward(request, response);
    	//////////////////회원가입 할 때 입력한 개인 정보를 내 정보 페이지에 표출 /////////////
    	

    	
    	
    	
   
    	 
    }

}
