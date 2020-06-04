package web.index.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import web.index.Service.RegLectureEvaluationService;
import web.index.entity.LectureEvaluation;

@WebServlet("/RegLectureEvaluation")
public class RegLectureEvaluationController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		 RegLectureEvaluationService  service = new  RegLectureEvaluationService ();
		String id  = (String) request.getSession().getAttribute("Signedid");
		String name = request.getParameter("name");
		String professor = request.getParameter("professor");
		String studyYear = request.getParameter("studyYear");
		String  studySemester= request.getParameter("studySemester");
		String title = request.getParameter("title");
		String  content= request.getParameter("content");
		String task = request.getParameter("task");
		String teample = request.getParameter("teample");
		String  gradescale= request.getParameter("gradescale");
		String  exam= request.getParameter("exam");
		String  totalScore= request.getParameter("totalScore");
		LectureEvaluation LE = new LectureEvaluation(id, name, professor, studyYear, studySemester, title, content, task, teample, gradescale, exam, totalScore);
	 int result = 	service.registerLectureEvaluation(LE);
	 
	 if(result ==1)
	 {
		 out.println("<script>alert('강의평가가 성공적으로 등록되었습니다.');</script>");
		 out.println("<script>window.close();</script>");
	 }
	 else
	 {
		 out.println("<script>alert('오류로 인해 강의평가 등록에 실패하였습니다.');</script>");
		 out.println("<script>alert('/RegLectureEvaluation.jsp');</script>");
		
	 }
		

		
	}
}
