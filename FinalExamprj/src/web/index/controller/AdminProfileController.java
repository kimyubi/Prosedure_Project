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
		//같은 이름을 가진 여러개의 파라미터 값을 받을 때는 배열로 받는다.
		// getParameterValues()는 배열을 리턴한다.

		if (deleteid != null)
		{

		   int result=	service.delete_id(deleteid);
		   if(result!=0)
		   {
			out.println("<script>alert('해당 계정이 성공적으로 삭제되었습니다.');</script>");
			out.println("<script>location.href='/adminprofile'</script>");
		   }
		   
		}
		else //삭제할 강의를 선택하지 않고 삭제 버튼을 눌렀을 때
		{
			out.println("<script>alert('선택한 삭제 항목이 없습니다.');</script>");
			out.println("<script>location.href='/adminprofile'</script>");
		}

	}
}
