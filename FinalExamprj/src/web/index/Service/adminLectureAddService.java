package web.index.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import web.index.entity.Lecture;

public class adminLectureAddService {

	public int adminLectureAdd(Lecture lecture)
	{
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "INSERT INTO LECTURE ( CODE, NAME, LOCATION, PERSONNEL, GRADES, PROFESSOR, TIME,  CAMPUS, COLLEAGE, DEPARTMENT)"
				+ " VALUES( ?,?,?,?,?,?,?,?,?,?) ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, lecture.getCode());
			st.setString(2, lecture.getName());
			st.setString(3, lecture.getLocation());
			st.setString(4, lecture.getPersonnel());
			st.setString(5, lecture.getGrades());
			st.setString(6, lecture.getProfessor());
			st.setString(7,lecture.getTime());
			st.setString(8, lecture.getCampus());
			st.setString(9, lecture.getColleage());
			st.setString(10, lecture.getDepartment());
			result= st.executeUpdate();
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
