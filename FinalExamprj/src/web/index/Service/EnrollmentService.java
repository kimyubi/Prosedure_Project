package web.index.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.index.entity.Lecture;
import web.index.entity.Notice;

public class EnrollmentService {
	
	public List<Lecture> lectureList()
	{
		return lectureList("code", "");
	}
	
	public List<Lecture> lectureList(String field, String search)
	{
		List<Lecture> list = new ArrayList<>();
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " SELECT * FROM (SELECT * FROM LECTURE WHERE CAMPUS = '인문캠퍼스' ) WHERE "+field+ " LIKE  ? " ;
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, "%" + search + "%");
				ResultSet rs= st.executeQuery();
				
				while (rs.next()) {
					String code = rs.getString("CODE");
					String name = rs.getString("NAME");
					String location= rs.getString("LOCATION");
					String personnel= rs.getString("PERSONNEL");
					String grades= rs.getString("GRADES");
					String professor= rs.getString("PROFESSOR");
					String time= rs.getString("TIME");

					Lecture lecture = new Lecture(code, name, location, personnel, grades, professor, time);
					list.add(lecture);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    return list;
	}
	public List<Lecture> lectureListJa(String field, String search)
	{
		List<Lecture> list = new ArrayList<>();
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " SELECT * FROM (SELECT * FROM LECTURE WHERE CAMPUS = '자연캠퍼스' ) WHERE "+field+ " LIKE  ? " ;
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, "%" + search + "%");
				ResultSet rs= st.executeQuery();
				
				while (rs.next()) {
					String code = rs.getString("CODE");
					String name = rs.getString("NAME");
					String location= rs.getString("LOCATION");
					String personnel= rs.getString("PERSONNEL");
					String grades= rs.getString("GRADES");
					String professor= rs.getString("PROFESSOR");
					String time= rs.getString("TIME");

					Lecture lecture = new Lecture(code, name, location, personnel, grades, professor, time);
					list.add(lecture);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    return list;
	}
	public List<Lecture> lectureListJa()
	{
		return lectureList("code", "");
	}
	
	
	
}
