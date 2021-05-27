package model;

public class Crs {
	private String login;
	private String pw;
	public Crs(String login, String pw) {
		super();
		this.login = login;
		this.pw = pw;
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
