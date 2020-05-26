package web.index.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index.Service.EnrollmentService;
import web.index.entity.Lecture;

@WebServlet("/enrollment")
public class EnrollmentCotroller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EnrollmentService service = new EnrollmentService();
		List<Lecture> list = new ArrayList<Lecture>();

		String field = "code";
		String field_ = request.getParameter("selection");
		if (field_ != null && !field_.equals(" ")) {
			field = field_;
		}

		String search = "";
		String search_ = request.getParameter("search");
		if (search_ != null && !search_.equals("")) {
			search = search_;
		}
		list = service.lectureList(field, search);
		request.setAttribute("list", list);

		request.getRequestDispatcher("/enrollment.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		EnrollmentService service = new EnrollmentService();
		String id = (String) request.getSession().getAttribute("Signedid");
		String code_ = request.getParameter("code");
		String code = null ;
		if(code_!=null&&!code_.equals(""))
		{
			code= code_;
		}
		int result = service.enrollment(id, code);
		if(result ==1)
		{
			out.println("<script>alert('수강 신청되었습니다.');</script>");
			out.println("<script>location.href='/enrollment'</script>");
		
		}
		if(result==0)
		{
			out.println("<script>alert('이미 수강신청 하셨습니다.');</script>");
			out.println("<script>location.href='/enrollment'</script>");
		}
		
	}
}
