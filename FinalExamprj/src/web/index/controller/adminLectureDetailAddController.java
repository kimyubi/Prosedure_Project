package web.index.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index.Service.adminLectureDetailAddService;
import web.index.entity.LectureDetail;
import web.index.entity.WeeklyProgress;

@WebServlet("/adminLectureDetailAdd")
public class adminLectureDetailAddController extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		request.setCharacterEncoding("UTF-8");
 		response.setCharacterEncoding("UTF-8");
 		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
    	 
    	String code =  request.getParameter("code");
    	String email =   request.getParameter("email");
    	String goal =  request.getParameter("goal");
    	String book =  request.getParameter("book");
    	String gradeevaluation =  request.getParameter("gradeevaluation");
    	String week1 =  request.getParameter("week1");
    	String week2 =  request.getParameter("week2");
    	String week3 =  request.getParameter("week3");
    	String week4 =   request.getParameter("week4");
    	String week5 = request.getParameter("week5");
    	String week6 =   request.getParameter("week6");
    	String week7 =  request.getParameter("week7");
    	String week8 =  request.getParameter("week8");
    	String week9 =   request.getParameter("week9");
    	String week10 =  request.getParameter("week10");
       	String week11 =   request.getParameter("week11");
       	String week12 =  request.getParameter("week12");
       	String week13 =  request.getParameter("week13");
       	String week14 =  request.getParameter("week14");
       	String week15 =   request.getParameter("week15");
       	String week16 =  request.getParameter("week16");
       	
       	LectureDetail lectureDetail = new LectureDetail(code, email, goal, gradeevaluation, book);
       	WeeklyProgress weeklyProgress = new WeeklyProgress(code, week1, week2, week3, week4, week5, week6, week7, week8, week9, week10, week11, week12, week13, week14, week15, week16);
       	
       	adminLectureDetailAddService service = new adminLectureDetailAddService();
       int result1 = 	service.setLectureDetail(lectureDetail);
       int result2 = service.setWeeklyProgress(weeklyProgress);
       
       if(result1==1&&result2==1)
       {
    	   out.println("<script>alert('강의계획서가 성공적으로 등록되었습니다.');</script>");
	   	   out.println("<script>location.href='/adminenrollment'</script>");
       }
       else
       {
    	   out.println("<script>alert('해당 강좌의 강의계획서가 이미 존재합니다.');</script>");
	   	   out.println("<script>location.href='/adminenrollment'</script>");
       }
       
    	
    	 
    }
	
}
