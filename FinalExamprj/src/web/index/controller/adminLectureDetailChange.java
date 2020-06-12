package web.index.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index.Service.AdminNoticeService;
import web.index.Service.LecturePlanService;
import web.index.Service.adminLectureDetailAddService;
import web.index.entity.LectureDetail;
import web.index.entity.LecturePlan;
import web.index.entity.Notice;
import web.index.entity.WeeklyProgress;

@WebServlet("/lecturedetailChange")
public class adminLectureDetailChange extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//adminlecturedetail.jsp 페이지에서 수정버튼을 누르면 이 페이지로 이동한다.
		//항상 /adminlecturedetail.jsp ?code=[수정할 강의의 과목코드] 의 형식으로 온다.
		LecturePlanService service = new LecturePlanService();
		
		String code = request.getParameter("code");
		request.getSession().setAttribute("code", code);
		LecturePlan plan =  service.getLecturePlan(code);
		//과목코드가 code인 강의의 강의 계획서를 꺼내온다. 
		
	    request.setAttribute("plan",plan);
	request.getRequestDispatcher("/adminLectureDetailChange.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
 		response.setCharacterEncoding("UTF-8");
 		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
    	 
    	String code = (String) request.getSession().getAttribute("code");
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
       if(code!=null&&!code.equals(""))
       {
    	   int result1 = 	service.updateLectureDetail(lectureDetail);
           int result2 = service.updateWeeklyProgress(weeklyProgress);
           if(result1==1&&result2==1)
           {
        	   out.println("<script>alert('강의계획서가 성공적으로 수정되었습니다.');</script>");
    	   	   out.println("<script>location.href='/adminlecturedetail?code="+code+"'</script>");
           }
           else
           {
        	   out.println("<script>alert('오류로 인해 강의계획서 수정에 실패하셨습니다..');</script>");
    	   	   out.println("<script>location.href='/adminlecturedetail?code="+code+"'</script>");
           }
    	   
       }
       else
       {
    	   out.println("<script>alert(' 수정할 강의계획서가 없습니다. \\n 강의계획서 추가 버튼을 눌러 강의계획서를 추가한 후 이용하세요.');</script>");
	   	   out.println("<script>location.href='/adminlecturedetail?code="+code+"'</script>");
       }
   
     
       
    	
    	 
    }
		
	}


