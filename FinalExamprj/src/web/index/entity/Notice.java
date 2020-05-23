package web.index.entity;

import java.sql.Date;

public class Notice {
	private int id;
	@Override
	public String toString() {
		return "noticeInform [id=" + id + ", title=" + title + ", nickname=" + nickname + ", content=" + content
				+ ", date=" + date + ", hit=" + hit + ", files=" + files + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public Notice(int id, String title, String nickname, String content, Date date, int hit, String files) {
		super();
		this.id = id;
		this.title = title;
		this.nickname = nickname;
		this.content = content;
		this.date = date;
		this.hit = hit;
		this.files = files;
	}
	public Notice(String title, String content, String nickname)
	{
		this.title = title;
		this.content = content;
		this.nickname= nickname;
	}
	private String title;
	private String nickname ;
	private String content ;
	private Date date;
	private int hit ;
	private String files ;
	

}
