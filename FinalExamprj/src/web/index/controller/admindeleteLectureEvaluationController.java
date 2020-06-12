package web.index.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index.Service.LectureEvaluationListService;

@WebServlet("/admindeleteLectureEvaluation")
public class admindeleteLectureEvaluationController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		LectureEvaluationListService service = new LectureEvaluationListService();
		String num = request.getParameter("num");
		//LectureEvaluation.jsp 의 hidden태그 중 아이디가 num인 것의 파라미터를 받는다.
		
	
			int result = service.deleteEvaluationLecture(num); //삭제할 글의 번호를 매개변수로 주어 해당 글을 삭제한다.
			if(result ==1)// st.executeUpdate()가 성공적으로 실행되어 1을 리턴했다면
			{
				out.println("<script>alert('강의평가가 성공적으로 삭제되었습니다.');</script>");
	    		out.println("<script>location.href='/adminLectureEvaluation'</script>");
			}
			else// st.executeUpdate()가 성공적으로 실행되지 않고 0을 리턴했다면
			{
				out.println("<script>alert('오류로 인해 삭제에 실패하였습니다.');</script>");
				out.println("<script>location.href='/adminLectureEvaluation'</script>");
			}
		}
	
	}



