package web.index.controller;

import java.io.IOException;
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

import web.index.Service.NoticeService;
import web.index.entity.Notice;

@WebServlet("/notice")
public class NoticeListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		NoticeService service = new NoticeService();

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
	

		RequestDispatcher dispatcher = request.getRequestDispatcher("/notice.jsp");
		dispatcher.forward(request, response);
	
	
	}
}
