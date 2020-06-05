package web.index.entity;

public class LectureEvaluation {
	
	String id;
	String name;
	String professor;
	String studyYear;
	String studySemester;
	String title;
	String content;
	String task;
	String teample;
	String gradescale;
	String exam;
	String totalScore;
	String num;
	

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public LectureEvaluation(String id, String name, String professor, String studyYear, String studySemester,
			String title, String content, String task, String teample, String gradescale, String exam,
			String totalScore, String num) {
		super();
		this.id = id;
		this.name = name;
		this.professor = professor;
		this.studyYear = studyYear;
		this.studySemester = studySemester;
		this.title = title;
		this.content = content;
		this.task = task;
		this.teample = teample;
		this.gradescale = gradescale;
		this.exam = exam;
		this.totalScore = totalScore;
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getStudyYear() {
		return studyYear;
	}
	public void setStudyYear(String studyYear) {
		this.studyYear = studyYear;
	}
	public String getStudySemester() {
		return studySemester;
	}
	public void setStudySemester(String studySemester) {
		this.studySemester = studySemester;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getTeample() {
		return teample;
	}
	public void setTeample(String teample) {
		this.teample = teample;
	}
	public String getGradescale() {
		return gradescale;
	}
	public void setGradescale(String gradescale) {
		this.gradescale = gradescale;
	}
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	public String getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}
	public LectureEvaluation(String id, String name, String professor, String studyYear, String studySemester,
			String title, String content, String task, String teample, String gradescale, String exam,
			String totalScore) {
		super();
		this.id = id;
		this.name = name;
		this.professor = professor;
		this.studyYear = studyYear;
		this.studySemester = studySemester;
		this.title = title;
		this.content = content;
		this.task = task;
		this.teample = teample;
		this.gradescale = gradescale;
		this.exam = exam;
		this.totalScore = totalScore;
	}

}
