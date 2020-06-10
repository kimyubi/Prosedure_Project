package web.index.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index.Service.LectureEvaluationListService;
import web.index.entity.LectureEvaluation;

@WebServlet("/LectureEvaluation")
public class LectureEvaluationController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LectureEvaluation> list = new ArrayList<LectureEvaluation>();
		LectureEvaluationListService service = new LectureEvaluationListService();
		String field = "name";
		String field_ = request.getParameter("selection");
		if(field_!=null&&!field_.equals(""))
		{
			field = field_;
		}
		String query = "";
		String query_ = request.getParameter("search");
		if(query_!=null&&!query_.equals(""))
		{
			query = query_;
		}
		
		list = service.getLectureEvaluationList(field, query);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/LectureEvaluation.jsp").forward(request, response);
   //검색 기능을 구현하기 위한 코드 
}
}
