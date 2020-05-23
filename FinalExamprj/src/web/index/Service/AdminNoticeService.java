package web.index.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import web.index.entity.Notice;

public class AdminNoticeService {

	private List<Notice> list;
	private List<Notice> list2;

	public List<Notice> getNoticeList() {
		return getNoticeList("title", "", 1);

	}

	public List<Notice> getNoticeList(int page) {
		return getNoticeList("title", "", page);

	}

	public List<Notice> getNoticeList(String field/* TITLE/NICKNAME */, String query, int page) {
		List<Notice> list = new ArrayList<>();
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " SELECT * FROM(SELECT ROWNUM NUM, N.* FROM (SELECT * FROM NOTICE WHERE " + field + " LIKE ? "
				+ " ) N ) WHERE NUM BETWEEN ? AND ?  ";
		// page가 1일때 1, page가 2일때 11,......21,31,41 1+(page-1)*10
		// page가 1일 때 10, page가 2일때 20 ,....30 40 50 60 70
		// 즉 page가 1일때 1~10 페이지가 2일때 11~20 페이지가 3일때 21~30 ....

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, 1 + (page - 1) * 10);
			st.setInt(3, page * 10);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date date = rs.getDate("REGDATE");
				String nickname = rs.getString("NICKNAME");
				int hit = rs.getInt("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");

				Notice notice = new Notice(id, title, nickname, content, date, hit, files);
				list.add(notice);

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

	public Notice getNoties(int id) {
		Notice notice = null;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " SELECT * FROM NOTICE WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
			int nid = rs.getInt("ID");
			String title = rs.getString("TITLE");
			Date date = rs.getDate("REGDATE");
			String nickname = rs.getString("NICKNAME");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");
			String content = rs.getString("CONTENT");
			notice = new Notice(nid, title, nickname, content, date, hit, files);
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return notice;

	}

	public int deleteNotice(int[] delete_id) {
		int result  =0;  // 삭제한 갯수 
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String str = "";
		
		for(int i=0;i<delete_id.length;i++)
		{
			str+=delete_id[i];
			if(i<delete_id.length-1)// 배열의 마지막 인덱스 다음에는 ","가 붙지 않아야 함
			{
				str+=",";
			}
		}
		String sql = " DELETE NOTICE  WHERE ID IN (" + str + " ) "; //WHERE ID IN(, , , ,) IN()안에 있는 , 를 구분자로 하는 모든 ID.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			Statement st = con.createStatement();
			 result = st.executeUpdate(sql); //delete, update, insert는 executeQuery(x) executeUpdate
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	
		
	}
	
	public void insertNotice(Notice notice)
	{		
		
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " INSERT INTO NOTICE (TITLE, NICKNAME, CONTENT, REGDATE) VALUES( ?,?,?,SYSDATE)";

		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, notice.getTitle());
				st.setString(2, notice.getNickname());
				st.setString(3, notice.getContent());
				 st.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

	



}
