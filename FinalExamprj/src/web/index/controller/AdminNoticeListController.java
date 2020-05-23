package web.index.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index.Service.AdminNoticeService;
import web.index.Service.NoticeService;
import web.index.entity.Notice;

@WebServlet("/adminnotice")
public class AdminNoticeListController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String[] deleteid = request.getParameterValues("delete-id");
		if(deleteid==null)
		{
			out.println("<script>alert('선택한 삭제 항목이 없습니다.');</script>");
		    out.println("<script>location.href='/adminnotice'</script>");
		}
		else {
		int[] delete_id= new int[deleteid.length];
		AdminNoticeService service = new AdminNoticeService();
		
		
		for(int i=0;i<deleteid.length;i++)
		{
			delete_id[i] = Integer.parseInt(deleteid[i]);
		}
		
		int result = service.deleteNotice(delete_id);
		request.setAttribute("result", result);
		
		out.println("<script>alert('선택한 항목이 삭제 되었습니다.');</script>");
        out.println("<script>location.href='/adminnotice'</script>");//삭제 항목을 삭제한 후 새로고침 하는 역할
		}

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AdminNoticeService service = new AdminNoticeService();

		int page =1;
		String page_ = request.getParameter("p");
         if(page_!=null&&!page_.equals(""))
         {
        	 page = Integer.parseInt(page_);
         }
         String field = "title";
         String field_ = request.getParameter("selection");
         if(field_!=null&&!field_.equals(""))
         {
        	 field = field_;
         }
         String query = "";
         String query_=request.getParameter("search");
         if(query_!=null&&!query_.equals(""))
         {
        	 query = query_;
         }
          
         
		List<Notice> list  =service. getNoticeList(field , query, page);
		
		request.setAttribute("list", list);
	

		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminnotice.jsp");
		dispatcher.forward(request, response);
	
	
	}
}
