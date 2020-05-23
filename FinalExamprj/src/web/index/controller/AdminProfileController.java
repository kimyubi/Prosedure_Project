package web.index.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index.Service.AdminProfileService;
import web.index.entity.personalinfo;

@WebServlet("/adminprofile")
public class AdminProfileController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminProfileService service = new AdminProfileService();

		List<personalinfo> list = new ArrayList<personalinfo>();
		list = service.showProfile();

		request.setAttribute("infolist", list);
		// 회원 정보 목록을 보여준다.

		RequestDispatcher dispatcher = request.getRequestDispatcher("/adminprofile.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminProfileService service = new AdminProfileService();

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String[] deleteid = request.getParameterValues("select");

		if (deleteid != null) 
		{

		   int result=	service.delete_id(deleteid);
		
			out.println("<script>alert('해당 계정이 성공적으로 삭제되었습니다.');</script>");
			out.println("<script>location.href='/adminprofile'</script>");
		   
		}
		else
		{
			out.println("<script>alert('선택한 삭제 항목이 없습니다.');</script>");
			out.println("<script>location.href='/adminprofile'</script>");
		}

	}
}
