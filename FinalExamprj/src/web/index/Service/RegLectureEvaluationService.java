package web.index.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.index.entity.LectureEvaluation;

public class RegLectureEvaluationService {
	
	public int registerLectureEvaluation(LectureEvaluation LE)
	{
		int result = 0;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " INSERT INTO LECTUREEVALUATION ( ID, NAME, PROFESSOR, STUDYYEAR, STUDYSEMESTER, TITLE, CONTENT, "
				+ " TASK,TEAMPLE, GRADESCALE, EXAM, TOTALSCORE )  VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, LE.getId());
				st.setString(2, LE.getName());
				st.setString(3, LE.getProfessor());
				st.setString(4, LE.getStudyYear());
				st.setString(5,LE.getStudySemester());
				st.setString(6, LE.getTitle());
				st.setString(7, LE.getContent());
				st.setString(8, LE.getTask());
				st.setString(9, LE.getTeample());
				st.setString(10, LE.getGradescale());
				st.setString(11, LE.getExam());
				st.setString(12, LE.getTotalScore());
			
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
