package web.index.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index.Service.AdminNoticeService;
import web.index.Service.LecturePlanService;
import web.index.entity.LecturePlan;
import web.index.entity.Notice;

@WebServlet("/lecturedetailJa")
public class LecturePlanJaController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LecturePlanService service = new LecturePlanService();
		
		String code = request.getParameter("code");
		LecturePlan plan =  service.getLecturePlan(code);
	    request.setAttribute("plan",plan);

		
	request.getRequestDispatcher("/lecturedetailJa.jsp").forward(request, response);
		
	}

}
