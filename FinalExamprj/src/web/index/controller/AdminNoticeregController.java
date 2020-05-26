package web.index.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index.Service.AdminNoticeService;
import web.index.entity.Notice;

@WebServlet("/adminnoticereg")
public class AdminNoticeregController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	   AdminNoticeService service = new AdminNoticeService();
		PrintWriter out = response.getWriter();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
	    String nickname = (String) request.getSession().getAttribute("adminid");
	    Notice notice = new Notice(title, content, nickname);
	    
	    if(content!=null&&!content.equals("")&&title!=null&&!title.equals(""))
	    {
	    	service.insertNotice(notice);
	    	out.println("<script>alert('글이 성공적으로 등록되었습니다.');</script>");
			out.println("<script>location.href='/adminnotice'</script>");
	 
	    }
	    
	    else
	    {
	    	out.println("<script>alert('제목과 내용을 모두 입력해주세요.');</script>");
			out.println("<script>location.href='/adminnoticereg.jsp'</script>");
	    }
	    
	    
  // request.getRequestDispatcher("/adminnotice").forward(request, response);
		
	}

}
