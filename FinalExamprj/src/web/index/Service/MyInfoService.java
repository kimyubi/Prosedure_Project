package web.index.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.index.entity.personalinfo;

public class MyInfoService {
	public personalinfo getInfo(String id) {
		personalinfo myinfo = null;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "  SELECT NAME, TEL, EMAIL FROM PERSONALINFO WHERE ID = ? " ;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs= st.executeQuery();
			if(rs.next())
			{
				String name = rs.getString("NAME");
				String emil= rs.getString("EMAIL");
				String tel = rs.getString("TEL");
				 myinfo = new personalinfo(id, null, null, emil, tel, name);
		
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myinfo;
	
	}
	
	
	public String myMaxGrades(String id)
	{
		String myMaxGrades= "";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " SELECT * FROM(SELECT *FROM( SELECT MYINFO.ID, COLLEAGE.COLLEAGE, COLLEAGE.MAXGRADES ,MYINFO.REGDATE "
				+ "FROM COLLEAGE JOIN MYINFO ON MYINFO.COLLEAGE = COLLEAGE.COLLEAGE WHERE ID = ? ) "
				+ "ORDER BY REGDATE DESC) WHERE ROWNUM=1 " ;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con;
			con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs= st.executeQuery();
			if(rs.next())
			{
				myMaxGrades= rs.getString("MAXGRADES");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myMaxGrades;
	
	}
	
	public int  setInfo(String id , String colleage)
	{
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " INSERT INTO MYINFO ( ID, COLLEAGE ,REGDATE) VALUES ( ?,  ?, SYSDATE ) " ;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con;
			con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, colleage);
			result =st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	

		
	}


