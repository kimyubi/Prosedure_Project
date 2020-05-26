package web.index.entity;

public class EnrollmentList {

	private String code;
	private String name;
	private String location;
	private String personnel;
	private String grades;
	private String professor;
	private String time;
	private String campus;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPersonnel() {
		return personnel;
	}
	public void setPersonnel(String personnel) {
		this.personnel = personnel;
	}
	public String getGrades() {
		return grades;
	}
	public void setGrades(String grades) {
		this.grades = grades;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public EnrollmentList(String code, String name, String location, String personnel, String grades, String professor,
			String time, String campus) {
		super();
		this.code = code;
		this.name = name;
		this.location = location;
		this.personnel = personnel;
		this.grades = grades;
		this.professor = professor;
		this.time = time;
		this.campus = campus;
	}
	@Override
	public String toString() {
		return "EnrollmentList [code=" + code + ", name=" + name + ", location=" + location + ", personnel=" + personnel
				+ ", grades=" + grades + ", professor=" + professor + ", time=" + time + ", campus=" + campus + "]";
	}
	
	
}
