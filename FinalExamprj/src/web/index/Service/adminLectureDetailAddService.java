package web.index.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import web.index.entity.LectureDetail;
import web.index.entity.WeeklyProgress;

public class adminLectureDetailAddService {

	public int setLectureDetail(LectureDetail lectureDetail)
	{
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " INSERT INTO LECTUREDETAIL ( CODE, EMAIL, GOAL, GRADEEVALUATION, BOOK ) "
				+ " VALUES ( ?,?,?,?,? ) ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, lectureDetail.getCode());
			st.setString(2, lectureDetail.getEmail());
			st.setString(3,lectureDetail.getGoal());
			st.setString(4, lectureDetail.getGradeevaluation());
			st.setString(5, lectureDetail.getBook());
			result =  st.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	

	public int updateLectureDetail(LectureDetail lectureDetail)
	{
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " UPDATE LECTUREDETAIL SET\r\n" + 
				" EMAIL = ? ,\r\n" + 
				" GOAL = ?,\r\n" + 
				" GRADEEVALUATION = ?,\r\n" + 
				" BOOK =?\r\n" + 
				" WHERE CODE = ? ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, lectureDetail.getEmail());
			st.setString(2,lectureDetail.getGoal());
			st.setString(3, lectureDetail.getGradeevaluation());
			st.setString(4, lectureDetail.getBook());
			st.setString(5, lectureDetail.getCode());
			result =  st.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	public int setWeeklyProgress(WeeklyProgress weeklyProgress)
	{
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " INSERT INTO WEEKLYPROGRESS ( CODE, WEEK1, WEEK2, WEEK3, WEEK4, WEEK5, WEEK6, WEEK7, "
				+ " WEEK8, WEEK9, WEEK10, WEEK11, WEEK12, WEEK13, WEEK14, WEEK15, WEEK16)  VALUES "
				+ " ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ) ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, weeklyProgress.getCode());
			st.setString(2, weeklyProgress.getWeek1());
			st.setString(3,weeklyProgress.getWeek2());
			st.setString(4, weeklyProgress.getWeek3());
			st.setString(5,weeklyProgress.getWeek4());
			st.setString(6,weeklyProgress.getWeek5());
			st.setString(7,weeklyProgress.getWeek6());
			st.setString(8,weeklyProgress.getWeek7());
			st.setString(9,weeklyProgress.getWeek8());
			st.setString(10,weeklyProgress.getWeek9());
			st.setString(11,weeklyProgress.getWeek10());
			st.setString(12,weeklyProgress.getWeek11());
			st.setString(13,weeklyProgress.getWeek12());
			st.setString(14,weeklyProgress.getWeek13());
			st.setString(15,weeklyProgress.getWeek14());
			st.setString(16,weeklyProgress.getWeek15());
			st.setString(17,weeklyProgress.getWeek16());
			result =  st.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	public int updateWeeklyProgress(WeeklyProgress weeklyProgress)
	{
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " UPDATE WEEKLYPROGRESS SET\r\n" + 
				"WEEK1 = ?,\r\n" + 
				"WEEK2 = ?,\r\n" + 
				"WEEK3 = ?,\r\n" + 
				"WEEK4 = ?,\r\n" + 
				"WEEK5 = ?,\r\n" + 
				"WEEK6 = ?,\r\n" + 
				"WEEK7 = ?,\r\n" + 
				"WEEK8 = ?,\r\n" + 
				"WEEK9 = ?,\r\n" + 
				"WEEK10 = ?,\r\n" + 
				"WEEK11 = ?,\r\n" + 
				"WEEK12 = ?,\r\n" + 
				"WEEK13 = ?,\r\n" + 
				"WEEK14 = ?,\r\n" + 
				"WEEK15 = ?,\r\n" + 
				"WEEK16 = ?\r\n" + 
				"WHERE CODE = ? ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, weeklyProgress.getWeek1());
			st.setString(2,weeklyProgress.getWeek2());
			st.setString(3, weeklyProgress.getWeek3());
			st.setString(4,weeklyProgress.getWeek4());
			st.setString(5,weeklyProgress.getWeek5());
			st.setString(6,weeklyProgress.getWeek6());
			st.setString(7,weeklyProgress.getWeek7());
			st.setString(8,weeklyProgress.getWeek8());
			st.setString(9,weeklyProgress.getWeek9());
			st.setString(10,weeklyProgress.getWeek10());
			st.setString(11,weeklyProgress.getWeek11());
			st.setString(12,weeklyProgress.getWeek12());
			st.setString(13,weeklyProgress.getWeek13());
			st.setString(14,weeklyProgress.getWeek14());
			st.setString(15,weeklyProgress.getWeek15());
			st.setString(16,weeklyProgress.getWeek16());
			st.setString(17, weeklyProgress.getCode());
			
			result =  st.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
}
