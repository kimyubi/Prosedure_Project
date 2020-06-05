package web.index.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.index.entity.LectureEvaluation;
import web.index.entity.Notice;

public class LectureEvaluationListService {
	
	public List<LectureEvaluation> getLectureEvaluationList(String field, String query) {
		List<LectureEvaluation> list = new ArrayList<LectureEvaluation>();
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " SELECT * FROM LECTUREEVALUATION WHERE "+ field + " LIKE  ? "; 

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String id = rs.getString("ID");
				String name=rs.getString("NAME");
				String professor=rs.getString("PROFESSOR");
				String studyYear=rs.getString("STUDYYEAR");
				String studySemester=rs.getString("STUDYSEMESTER");
				String title=rs.getString("TITLE");
				String content=rs.getString("CONTENT");
				String task=rs.getString("TASK");
				String teample=rs.getString("TEAMPLE");
				String gradescale=rs.getString("GRADESCALE");
				String exam=rs.getString("EXAM");
				String totalScore=rs.getString("TOTALSCORE");
				String num = rs.getString("NUM");
				LectureEvaluation lectureEvaluation = new LectureEvaluation(id, name, professor, studyYear, studySemester, title, content, task, teample, gradescale, exam, totalScore, num);
				list.add(lectureEvaluation);

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

}
