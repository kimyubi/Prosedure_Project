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
		//LectureEvaluation.jsp 의 hidden태그 중 아이디가 id와 num인 것의 파라미터를 받는다.
		
		String signedid = (String) request.getSession().getAttribute("Signedid");
		//삭제할 글의 작성자 아이디와 현재 로그인 중인 사용자의 아이디가 동일한지 비교하기 위해, 현재 로그인중인 사용자의 아이디를 꺼낸다.
		
		if(postsid.equals(signedid)) //삭제할 글의 작성자 아이디와 사용자의 아이디가 같다면
		{
			int result = service.deleteEvaluationLecture(num); //삭제할 글의 번호를 매개변수로 주어 해당 글을 삭제한다.
			if(result ==1)// st.executeUpdate()가 성공적으로 실행되어 1을 리턴했다면
			{
				out.println("<script>alert('강의평가가 성공적으로 삭제되었습니다.');</script>");
	    		out.println("<script>location.href='/LectureEvaluation'</script>");
			}
			else// st.executeUpdate()가 성공적으로 실행되지 않고 0을 리턴했다면
			{
				out.println("<script>alert('오류로 인해 삭제에 실패하였습니다.');</script>");
				out.println("<script>location.href='/LectureEvaluation'</script>");
			}
		}
		else //삭제할 글의 작성자 아이디와 사용자의 아이디가 다르다면
		{
			out.println("<script>alert('자신이 작성한 글만 삭제할 수 있습니다.');</script>");
    		out.println("<script>location.href='/LectureEvaluation'</script>");
		}
	}


}
