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

@WebServlet("/enrollmentJa")
public class EnrollmentJaCotroller extends HttpServlet {
	
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
		
		String id = (String) request.getSession().getAttribute("Signedid");
		int totalGrades = 0;
		String totalGrades_= service.totalGrades(id);
		if(totalGrades_!=null&&!totalGrades_.equals(""))
		{
			totalGrades = Integer.parseInt(totalGrades_);
		}
		
		request.setAttribute("totalGrades", totalGrades);
		request.getSession().setAttribute("totalGrades", totalGrades);

		request.getRequestDispatcher("/enrollmentJa.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//인코딩 UTF-8로 설정
		
		PrintWriter out = response.getWriter();
		
		EnrollmentService service = new EnrollmentService();
		String id = (String) request.getSession().getAttribute("Signedid");
		String code_ = request.getParameter("code");
		int total = (int) request.getSession().getAttribute("totalGrades");
		int max = (int) request.getSession().getAttribute("maxgrades");
		String code = null ;
		if(code_!=null&&!code_.equals(""))
		{
			code= code_;
		}

		//수강 신청할 강좌의 코드를 주면서 학점을 가져와서 int willEnrollGrade에 저장한다.
		//if (willEnrollGrade+ total>max)이 true 면 service. enroll실행하지 않고 alert('수강신청 가능한 학점을 초과~~'), else일 때 service. enrollment실행
		
		int willeEnrollGrade = service.getWillEnrollGrade(code);
		if(willeEnrollGrade+total>max)
		{
			
			out.println("<script>alert('수강신청 가능한 학점을 초과하셨습니다.');</script>");
			out.println("<script>location.href='/enrollmentJa'</script>");
		}
		
		else 
		{   
		     int result = service.enrollment(id, code);
		     if(result ==1)
	    	   {
			       out.println("<script>alert('수강 신청되었습니다.');</script>");
		    	   out.println("<script>location.href='/enrollmentJa'</script>");
		
	        	}
		   if(result==0)
		     {
		     	out.println("<script>alert('이미 수강신청 하셨습니다.');</script>");
			    out.println("<script>location.href='/enrollmentJa'</script>");
		    }
	   	}
		
	}
}

