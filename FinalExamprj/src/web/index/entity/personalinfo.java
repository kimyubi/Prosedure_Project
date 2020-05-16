package web.index.entity;

public class personalinfo {

	private String id;
	private String password;
	private String nickname;
	private String email;
	private String tel;
	private String name;
	
	public personalinfo(String id, String password, String nickname, String email, String tel, String name) {
	
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.tel = tel;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "personalinfo [id=" + id + ", password=" + password + ", nickname=" + nickname + ", email=" + email
				+ ", tel=" + tel + ", name=" + name + "]";
	}
	
	
	
	
}
