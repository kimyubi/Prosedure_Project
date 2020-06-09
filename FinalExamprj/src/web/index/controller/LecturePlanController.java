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

@WebServlet("/lecturedetail")
public class LecturePlanController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LecturePlanService service = new LecturePlanService();
		
		String code = request.getParameter("code");
		// /lecturedetail?code=? 와 같이 get방식으로 과목 코드 정보가 오게 된다.
		LecturePlan plan =  service.getLecturePlan(code);
		//Lectureplan: 강의계획서 정보를 담고있는 entity
	    request.setAttribute("plan",plan);

		
	request.getRequestDispatcher("/lecturedetail.jsp").forward(request, response);
		
	}

}
