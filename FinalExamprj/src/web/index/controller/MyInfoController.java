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
    	//현재 로그인 중인 아이디를 주면서, 해당 personalinfo의 name,email,tel을 꺼내와 personalinfo에 저장한 후 리턴한다.
    	request.setAttribute("myinfo", myinfo);
    	
    	
    	String colleage = request.getParameter("select");
    	//단과대 정보를 파라미터로 받아온다.
      
    	int result = service.setInfo(id, colleage);
    	if(result==1)  //아이디와 단과대 정보가 MYINFO에 성공적으로 INSERT되었으면,
    	{
    	 	out.println("<script>alert('저장되었습니다.');</script>");
	    	out.println("<script>location.href='/myinfo.jsp'</script>");
    	String maxgrades =	service.myMaxGrades(id);
        request.getSession().setAttribute("maxgrades", Integer.parseInt(maxgrades));
        //session에 maxgrades라는 이름으로 최대 이수가능학점을 저장하여 해당 사용자가 로그인하고 있는동안, 다른 페이지에서도 maxgrades를
       // 사용할 수 있도록 함
        
    	}
    	
    	
    	request.getRequestDispatcher("/MyInfo.jsp").forward(request, response);
    	//////////////////회원가입 할 때 입력한 개인 정보를 내 정보 페이지에 표출 /////////////
    	
 
    }

}
