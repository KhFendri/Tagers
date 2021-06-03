package application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials {
	private String login;
	private String pw;
	public Credentials(@JsonProperty("mail") String login,
			@JsonProperty("password") String pw) {
		super();
		this.login = (String)login;
		this.pw = (String)pw;
	}
	public String getLogin() {
		return login;
	}
	public String getPw() {
		return pw;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

}
