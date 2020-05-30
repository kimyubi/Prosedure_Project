package web.index.entity;

public class Lecture {

	private String code ;
	private String name;
	private String location;
	private String personnel;
	private String grades;
	private String professor;
	private String time;
	private String campus;
	private String colleage;
	private String department;

	public Lecture(String code, String name, String location, String personnel, String grades, String professor,
			String time, String campus, String colleage, String department) {
		super();
		this.code = code;
		this.name = name;
		this.location = location;
		this.personnel = personnel;
		this.grades = grades;
		this.professor = professor;
		this.time = time;
		this.campus = campus;
		this.colleage = colleage;
		this.department = department;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getColleage() {
		return colleage;
	}
	public void setColleage(String colleage) {
		this.colleage = colleage;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Lecture [code=" + code + ", name=" + name + ", location=" + location + ", personnel=" + personnel
				+ ", grades=" + grades + ", professor=" + professor + ", time=" + time + "]";
	}
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
	public Lecture(String code, String name, String location, String personnel, String grades, String professor,
			String time) {
		super();
		this.code = code;
		this.name = name;
		this.location = location;
		this.personnel = personnel;
		this.grades = grades;
		this.professor = professor;
		this.time = time;
	}

	
	
	
	
	
}
