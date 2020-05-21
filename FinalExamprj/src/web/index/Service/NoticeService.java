package web.index.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.index.entity.Notice;

public class NoticeService {

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
	


}
