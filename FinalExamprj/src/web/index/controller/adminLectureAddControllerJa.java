package web.index.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.index.Service.adminLectureAddService;
import web.index.entity.Lecture;

@WebServlet("/adminLectureAddJa")
public class adminLectureAddControllerJa extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//인코딩 UTF-8로 설정
		
		PrintWriter out = response.getWriter();
		
		adminLectureAddService service = new adminLectureAddService();
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String personnel = request.getParameter("personnel");
		String grades = request.getParameter("grades");
		String professor = request.getParameter("professor");
		String time = request.getParameter("time");
		String campus = request.getParameter("campus");
		String colleage = request.getParameter("colleage");
		String department = request.getParameter("department");
		
		Lecture lecture = new Lecture(code, name, location, personnel, grades, professor, time, campus, colleage, department);
		int result = service.adminLectureAdd(lecture);
		
		if(result==0)
		{
			out.println("<script>alert('과목코드가 중복됩니다. 과목 코드를 수정해주세요');</script>");
			out.println("<script>location.href='/adminLectureAdd.jsp'</script>");
		}
		else if(result==1)
		{
			out.println("<script>alert('해당 강의가 성공적으로 등록되었습니다.');</script>");
			out.println("<script>location.href='/adminenrollmentJa'</script>");
		
		}
		
		
		
		
		
		
		
	}

}
