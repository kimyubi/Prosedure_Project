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
import web.index.entity.delivery;

public class deliveryService {
	
	public List<delivery> getDeliveryList(String field, String query) {
		List<delivery> list = new ArrayList<>();
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " SELECT * FROM WOMAN WHERE "+ field+ " LIKE ? ";
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String uniqueid = rs.getString("UNIQUEID");
				String city = rs.getString("CITY");
				String citycountyname= rs.getString("CITYCOUNTYNAME");
				String roadname = rs.getString("ROADNAME");
				String facility = rs.getString("FACILITY");

				delivery del = new delivery(uniqueid, city, citycountyname, roadname, facility);
				list.add(del);

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

	public delivery getdeliverydetail(String uniqueid) {
		delivery del= null;
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " SELECT * FROM WOMAN WHERE UNIQUEID = ? ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "YUBI", "rlatldn11!");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,uniqueid);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				String uniqueid_ = rs.getString("UNIQUEID");
				String city = rs.getString("CITY");
				String citycountyname = rs.getString("CITYCOUNTYNAME");
				String roadname = rs.getString("ROADNAME");
				String facility = rs.getString("FACILITY");
				String citycountycode = rs.getString("CITYCOUNTYCODE");
				String branchaddress = rs.getString("BRANCHADRESS");
				String starttime = rs.getString("STARTTIME");
				String finaltime = rs.getString("FINALTIME");
				String satstart = rs.getString("SATSTART");
				String satfinal = rs.getString("SATFINAL");
				String holistart = rs.getString("HOLISTART");
				String holifinal = rs.getString("HOLIFINAL");
				String freehours = rs.getString("FREEHOURS");
				String costunittime = rs.getString("COSTUNITTIME");
				String cost = rs.getString("COST");
				String controlcode = rs.getString("CONTROLCODE");
				String howtouse = rs.getString("HOWTOUSE");
				String tel = rs.getString("TEL");
				String admintel = rs.getString("ADMINNAME");
				String adminname = rs.getString("ADMINNAME");
				del = new delivery(uniqueid_, city, citycountyname, roadname, facility, citycountycode, branchaddress, starttime, finaltime, satstart, satfinal, holistart, holifinal, freehours, costunittime, cost, controlcode, howtouse, tel, admintel, adminname);
			}
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return del;

	
	}

}
