package web.index.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index.Service.LectureEvaluationListService;

@WebServlet("/deleteLectureEvaluation")
public class deleteLectureEvaluationController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		LectureEvaluationListService service = new LectureEvaluationListService();
		String postsid = request.getParameter("id");
		String num = request.getParameter("num");
		String signedid = (String) request.getSession().getAttribute("Signedid");
		if(postsid.equals(signedid))
		{
			int result = service.deleteEvaluationLecture(num);
			if(result ==1)
			{
				out.println("<script>alert('강의평가가 성공적으로 삭제되었습니다.');</script>");
	    		out.println("<script>location.href='/LectureEvaluation'</script>");
			}
			else
			{
				out.println("<script>alert('오류로 인해 삭제에 실패하였습니다.');</script>");
				out.println("<script>location.href='/LectureEvaluation'</script>");
			}
		}
		else
		{
			out.println("<script>alert('자신이 작성한 글만 삭제할 수 있습니다.');</script>");
    		out.println("<script>location.href='/LectureEvaluation'</script>");
		}
	}


}
