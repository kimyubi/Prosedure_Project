package web.index.entity;

public class LectureDetail {
	
	private String code;
	private String email;
	private String goal;
	private String gradeevaluation;
	private String book;
	public LectureDetail(String code, String email, String goal, String gradeevaluation, String book) {
		super();
		this.code = code;
		this.email = email;
		this.goal = goal;
		this.gradeevaluation = gradeevaluation;
		this.book = book;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getGradeevaluation() {
		return gradeevaluation;
	}
	public void setGradeevaluation(String gradeevaluation) {
		this.gradeevaluation = gradeevaluation;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	
	

}
