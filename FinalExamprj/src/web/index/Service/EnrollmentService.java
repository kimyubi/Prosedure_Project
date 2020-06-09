package web.index.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.index.entity.EnrollmentList;
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
	
	public int enrollment(String id, String code)
	{   int rs =0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " INSERT INTO ENROLLMENT(ID,CODE) SELECT ?, ? FROM DUAL WHERE NOT EXISTS(SELECT ID FROM ENROLLMENT WHERE ID = ? AND CODE = ?) ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, code);
			st.setString(3, id);
			st.setString(4,code);
		 rs =  st.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return rs;
		
	}
	
	
	public int miridamgi(String id, String code)
	{   int rs =0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " INSERT INTO MIRIDAMGI(ID,CODE) SELECT ?, ? FROM DUAL WHERE NOT EXISTS(SELECT ID FROM MIRIDAMGI WHERE ID = ? AND CODE = ?) ";
	//MIRIDAMGI 테이블에 매개변수로 받은 ID와 CODE 모두가 동일한 행이 없다면 매개변수로 받은 ID와 CODE를 INSERT한다.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, code);
			st.setString(3, id);
			st.setString(4,code);
		 rs =  st.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return rs;
		
	}

	public List<EnrollmentList> showEnrollmentList(String id) {
	List<EnrollmentList>  list = new ArrayList<EnrollmentList>();
	String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	String sql= " SELECT CODE,NAME,LOCATION,PERSONNEL,GRADES,PROFESSOR,TIME,CAMPUS"
			+ " FROM(SELECT ENROLLMENT.ID, LECTURE.* FROM ENROLLMENT JOIN LECTURE ON ENROLLMENT.CODE =LECTURE.CODE ) "
			+ "WHERE ID = ? ";
	
	//LECTURE 테이블( 아이디, 과목 코드) LECTURE 테이블(과목 코드,과목명,강의실,학점,교수명, 강의시간, 캠퍼스 ....(생략))
	//두 테이블을 조인함으로써 해당 아이디(매개변수로 받은 아이디)가 신청한 강좌의 과목코드 뿐만이 아니라 신청한 강좌의 정보까지도 SELECT할 수 있음
	//매개변수로 받은 아이디가 수강신청한 강좌의 목록을 EnrollmentList(entity)에 담아 신청내역 페이지에 뿌려준다.

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
		    String code = rs.getString("CODE");
		    String name = rs.getString("NAME");
			String location =  rs.getString("LOCATION") ;
		    String personnel=rs.getString("PERSONNEL")  ;
		    String grades= rs.getString("GRADES") ;
			String professor = rs.getString("PROFESSOR");
			String time =rs.getString("TIME") ;
		    String campus= rs.getString("CAMPUS") ;
		  

		    EnrollmentList enrollmentlist = new EnrollmentList(code, name, location, personnel, grades, professor, time, campus);
			list.add(enrollmentlist);

		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	}
	
	public List<EnrollmentList> showMiridamgiList(String id) {
	List<EnrollmentList>  list = new ArrayList<EnrollmentList>();
	String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	String sql= " SELECT CODE,NAME,LOCATION,PERSONNEL,GRADES,PROFESSOR,TIME,CAMPUS"
			+ " FROM(SELECT MIRIDAMGI.ID, LECTURE.* FROM MIRIDAMGI JOIN LECTURE ON MIRIDAMGI.CODE =LECTURE.CODE ) "
			+ "WHERE ID = ? ";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
		    String code = rs.getString("CODE");
		    String name = rs.getString("NAME");
			String location =  rs.getString("LOCATION") ;
		    String personnel=rs.getString("PERSONNEL")  ;
		    String grades= rs.getString("GRADES") ;
			String professor = rs.getString("PROFESSOR");
			String time =rs.getString("TIME") ;
		    String campus= rs.getString("CAMPUS") ;
		  

		    EnrollmentList enrollmentlist = new EnrollmentList(code, name, location, personnel, grades, professor, time, campus);
			list.add(enrollmentlist);

		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	
	return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public String totalGrades(String id)
	{
		String totalGrades = "";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql= " SELECT SUM(GRADES) TOTALGRADES FROM (SELECT ID, GRADES FROM (SELECT ENROLLMENT.ID, LECTURE.* FROM ENROLLMENT JOIN LECTURE ON ENROLLMENT.CODE = LECTURE.CODE)) WHERE ID = ? ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				totalGrades= rs.getString("TOTALGRADES");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalGrades;
	}
	
	public String totalMiriGrades(String id)
	{
		String totalmiriGrades = "";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql= "  SELECT SUM(GRADES) TOTALMIRIGRADES FROM(SELECT GRADES  FROM ( SELECT MIRIDAMGI.ID, LECTURE.* FROM MIRIDAMGI JOIN LECTURE ON MIRIDAMGI.CODE = LECTURE.CODE ) WHERE ID = ? ) ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				totalmiriGrades= rs.getString("TOTALMIRIGRADES");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalmiriGrades;
	}
	
	
	
	
	
	
	public int  getWillEnrollGrade(String code)
	{
		int willenrollGrade=0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql= " SELECT GRADES FROM LECTURE WHERE CODE = ? ";

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,code);
				ResultSet rs = st.executeQuery();
				if(rs.next())
				{
					String willenrollGrade_ = rs.getString("GRADES");
					 willenrollGrade= Integer.parseInt(willenrollGrade_);
				}
		
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return willenrollGrade;
	
		
	}
	
    public int enrolledNum(String code)
    {
        int enrolledNum=0;
       String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
       String sql = " SELECT COUNT(*) ENROLLEDNUM FROM(SELECT ENROLLMENT.ID, LECTURE.*  "
       		+ "FROM ENROLLMENT JOIN LECTURE ON ENROLLMENT.CODE = LECTURE.CODE ) WHERE CODE= ? ";
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,code);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				String enrolledNum_ = rs.getString("ENROLLEDNUM");
				enrolledNum = Integer.parseInt(enrolledNum_);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
      
	  return enrolledNum;	
    	
    	
    }
    
    public int deleteLecture(String code)
    {
    	int result = 0;
    	 String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
         String sql = " DELETE LECTURE WHERE CODE = ?  ";
     	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, code);
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
    
    public int deleteLectureDetail(String code)
    {
    	int result = 0;
    	 String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
         String sql = " DELETE LECTUREDETAIL WHERE CODE = ?  ";
     	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, code);
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
    
    public int deleteWeeklyProgress(String code)
    {
    	int result = 0;
    	 String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
         String sql = " DELETE WEEKLYPROGRESS WHERE CODE = ?  ";
     	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, code);
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
