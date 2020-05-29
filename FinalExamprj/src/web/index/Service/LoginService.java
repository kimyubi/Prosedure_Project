package web.index.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
	
	public int logIn(String id , String password)
	{
		int result = 3;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " SELECT PASSWORD FROM PERSONALINFO WHERE ID= ? ";
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
			{
				if(password.equals(rs.getString("PASSWORD")))
				{
					result= 1;//로그인 성공
				}
				else
				{
					result = 2;//비밀번호를 잘못 입력하셨습니다.
				}
					
			}
			else
			{
				result = 3;//없는 계정입니다. 회원가입을 먼저 진행해주세요
			}
			
			con.close();
			st.close();
			
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
