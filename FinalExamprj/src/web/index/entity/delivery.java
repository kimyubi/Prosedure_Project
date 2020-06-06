package web.index.entity;

public class delivery {
	
	String uniqueid;
	String city;
	String citycountyname;
	String roadname;
	String facility;
	String citycountycode;
	String branchaddress;
	String starttime;
	String finaltime;
	String satstart;
	String satfinal;
	String holistart;
	String holifinal;
	String freehours;
	String costunittime;
	String cost;
	String controlcode;
	String howtouse;
	String tel;
	String admintel;
	String adminname;
	public delivery(String uniqueid, String city, String citycountyname, String roadname, String facility) {
		super();
		this.uniqueid = uniqueid;
		this.city = city;
		this.citycountyname = citycountyname;
		this.roadname = roadname;
		this.facility = facility;
	}
	public delivery(String uniqueid, String city, String citycountyname, String roadname, String facility,
			String citycountycode, String branchaddress, String starttime, String finaltime, String satstart,
			String satfinal, String holistart, String holifinal, String freehours, String costunittime, String cost,
			String controlcode, String howtouse, String tel, String admintel, String adminname) {
		super();
		this.uniqueid = uniqueid;
		this.city = city;
		this.citycountyname = citycountyname;
		this.roadname = roadname;
		this.facility = facility;
		this.citycountycode = citycountycode;
		this.branchaddress = branchaddress;
		this.starttime = starttime;
		this.finaltime = finaltime;
		this.satstart = satstart;
		this.satfinal = satfinal;
		this.holistart = holistart;
		this.holifinal = holifinal;
		this.freehours = freehours;
		this.costunittime = costunittime;
		this.cost = cost;
		this.controlcode = controlcode;
		this.howtouse = howtouse;
		this.tel = tel;
		this.admintel = admintel;
		this.adminname = adminname;
	}
	public String getUniqueid() {
		return uniqueid;
	}
	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCitycountyname() {
		return citycountyname;
	}
	public void setCitycountyname(String citycountyname) {
		this.citycountyname = citycountyname;
	}
	public String getRoadname() {
		return roadname;
	}
	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public String getCitycountycode() {
		return citycountycode;
	}
	public void setCitycountycode(String citycountycode) {
		this.citycountycode = citycountycode;
	}
	public String getBranchaddress() {
		return branchaddress;
	}
	public void setBranchaddress(String branchaddress) {
		this.branchaddress = branchaddress;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getFinaltime() {
		return finaltime;
	}
	public void setFinaltime(String finaltime) {
		this.finaltime = finaltime;
	}
	public String getSatstart() {
		return satstart;
	}
	public void setSatstart(String satstart) {
		this.satstart = satstart;
	}
	public String getSatfinal() {
		return satfinal;
	}
	public void setSatfinal(String satfinal) {
		this.satfinal = satfinal;
	}
	public String getHolistart() {
		return holistart;
	}
	public void setHolistart(String holistart) {
		this.holistart = holistart;
	}
	public String getHolifinal() {
		return holifinal;
	}
	public void setHolifinal(String holifinal) {
		this.holifinal = holifinal;
	}
	public String getFreehours() {
		return freehours;
	}
	public void setFreehours(String freehours) {
		this.freehours = freehours;
	}
	public String getCostunittime() {
		return costunittime;
	}
	public void setCostunittime(String costunittime) {
		this.costunittime = costunittime;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getControlcode() {
		return controlcode;
	}
	public void setControlcode(String controlcode) {
		this.controlcode = controlcode;
	}
	public String getHowtouse() {
		return howtouse;
	}
	public void setHowtouse(String howtouse) {
		this.howtouse = howtouse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdmintel() {
		return admintel;
	}
	public void setAdmintel(String admintel) {
		this.admintel = admintel;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	


}
