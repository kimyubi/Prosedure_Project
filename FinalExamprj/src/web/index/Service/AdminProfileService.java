package web.index.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import web.index.entity.personalinfo;

public class AdminProfileService {
	

	public List<personalinfo> showProfile() {
		List<personalinfo> infoList = new ArrayList<>(); 
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql =" SELECT * FROM PERSONALINFO ";
		// PERSONALINFO 테이블의 모든 행(레코드)를 꺼내온다. 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				String id = rs.getString("ID");
				String password = rs.getString("PASSWORD");
				String nickname = rs.getString("NICKNAME");
				String email = rs.getString("EMAIL");
				String tel = rs.getString("TEL");
				String name = rs.getString("NAME");
				personalinfo info = new personalinfo(id, password, nickname, email, tel, name);
				infoList.add(info);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return infoList;
	}

	public int delete_id(String[] deleteid) {
	    int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String str= "";
		
		for(int i=0;i<deleteid.length;i++)
		{
			str += "'"+ deleteid[i] +"'";
			if(i<deleteid.length-1)
			{
			str+=",";
			}
		}

		String sql = " DELETE PERSONALINFO WHERE ID IN (" + str + ") ";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			Statement st = con.createStatement();
			 result =  st.executeUpdate(sql);
			
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
