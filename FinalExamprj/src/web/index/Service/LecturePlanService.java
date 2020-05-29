package web.index.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import web.index.entity.LecturePlan;

public class LecturePlanService {
	
   public  LecturePlan getLecturePlan(String code)
   {
	    LecturePlan lectureplan = null;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " SELECT * FROM LECTURE JOIN LECTUREDETAIL ON LECTURE.CODE = LECTUREDETAIL.CODE JOIN WEEKLYPROGRESS ON LECTURE.CODE = WEEKLYPROGRESS.CODE WHERE LECTURE.CODE = ?";
	
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, code);
		     	ResultSet rs  = st.executeQuery();
		     	if(rs.next())
		     	{
		     		String code1= rs.getString("CODE");
		     		String name = rs.getString("NAME");
		     		String location = rs.getString("LOCATION");
		     		String personnel = rs.getString("PERSONNEL");
		     		String grades = rs.getString("GRADES");
		     		String professor = rs.getString("PROFESSOR");
		     		String time = rs.getString("TIME");
		     		String email = rs.getString("EMAIL");
		     		String goal = rs.getString("GOAL");
		     		String gradeevaluation = rs.getString("GRADEEVALUATION");
		     		String book  = rs.getString("BOOK");
		     		String week1 = rs.getString("WEEK1");
		     		String week2 = rs.getString("WEEK2");
		     		String week3 = rs.getString("WEEK3");
		     		String week4 = rs.getString("WEEK4");
		     		String week5 = rs.getString("WEEK5");
		     		String week6 = rs.getString("WEEK6");
		     		String week7 = rs.getString("WEEK7");
		     		String week8 = rs.getString("WEEK8");
		     		String week9 = rs.getString("WEEK9");
		     		String week10 = rs.getString("WEEK10");
		     		String week11 = rs.getString("WEEK11");
		     		String week12 = rs.getString("WEEK12");
		     		String week13 = rs.getString("WEEK13");
		     		String week14 = rs.getString("WEEK14");
		     		String week15= rs.getString("WEEK15");
		     		String week16= rs.getString("WEEK16");
		    	lectureplan = new LecturePlan(code1, name, location, personnel, grades, professor, time, email, goal, gradeevaluation, book, week1, week2, 
		    			week3, week4, week5, week6, week7, week8, week9, week10, week11, week12, week13, week14, week15, week16);
		     		
		     		
		     	}
		     	
		     	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lectureplan;
   }

	
}
