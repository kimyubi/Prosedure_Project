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
	//강의 테이블(과목코드,교과목명, 강의실,학점,교수명,강의시간)+ 강의 디테일 테이블(학습목표,평가방법,주교재)+주차계획서 테이블(WEEK1~WEEK16)
	//을 모두 조인한다. 이때 LECTUREDETAIL.CODE와 WEEKLYPROGRESS.CODE는 LECTURE.CODE를 참조한다.
	// CODE는 PK(Primary Key)->null이 아니고 유일해야 한다.(unique)
	// 이렇게 조인된 테이블을 매개변수로 받은 과목 코드로 검색하여 나온 하나의 행의 칼럼값을 LecturePlan이라는 entity에 담아서 강의계획서 화면에 뿌려준다.
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
