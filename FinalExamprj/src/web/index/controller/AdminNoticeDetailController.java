package web.index.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index.Service.AdminNoticeService;
import web.index.Service.NoticeService;
import web.index.entity.Notice;

@WebServlet("/admindetail")
public class AdminNoticeDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminNoticeService service = new AdminNoticeService();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Notice notice = service.getNoties(id);
		
			request.setAttribute("notice",notice);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admindetail.jsp");
		dispatcher.forward(request, response);
	}

}
