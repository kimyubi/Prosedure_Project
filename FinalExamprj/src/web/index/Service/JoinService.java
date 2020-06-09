package web.index.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import web.index.entity.personalinfo;

public class JoinService {

	public void registerAccount(personalinfo person) {

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " INSERT INTO PERSONALINFO VALUES(?,?,?,?,?,?) ";
		//PERSONALINFO라는 이름을 가진 테이블에 값을 집어넣는다.
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, person.getName());
			st.setString(2, person.getId());
			st.setString(3, person.getPassword());
			st.setString(4, person.getTel());
			st.setString(5, person.getNickname());
			st.setString(6, person.getEmail());
		
			 st.executeUpdate();
			 //INSERT,DELETE,UPDATE -> executeUpdate();
			 // executeUpdate()는 변화를 준 행의 개수를 반환한다. 
			 //SELECT -> executeQuery();
			
			con.close();
			st.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean checkDuplication(String id)
	{ 
		boolean result=false;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " SELECT ID FROM PERSONALINFO WHERE ID=? ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
		    st.setString(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				result =true;
			}
	
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
