package web.index.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteLectureService {

	public int  delete(String id , String code)
	{
		int result = 0; //result 는 삭제한 개수
		//현재 사용자의 아이디와 삭제할 강의의 과목 코드를 받아 db의  enrollment 테이블에서 해당 행 삭제
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "  DELETE FROM ENROLLMENT WHERE ID= ? AND CODE = ? ";
	
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,id);
				st.setString(2, code);
				result = st.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
			
	

	}
	
	public int  deleteMyBag(String id , String code)
	{
		int result = 0; //result 는 삭제한 개수
		//현재 사용자의 아이디와 삭제할 강의의 과목 코드를 받아 db의  enrollment 테이블에서 해당 행 삭제
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "  DELETE FROM MIRIDAMGI WHERE ID= ? AND CODE = ? ";
	
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,id);
				st.setString(2, code);
				result = st.executeUpdate();
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

