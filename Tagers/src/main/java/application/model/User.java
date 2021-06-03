package application.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	private String IDuser;
	private String name;
	private Credentials cr;

	public User(
			@JsonProperty("userid") String userid ,
			@JsonProperty("name") String name,
			@JsonProperty("login") String login,
			@JsonProperty("password") String pw) {
		super();
		
		 if (userid == null)
		IDuser = UUID.randomUUID().toString();
		 else 
			 IDuser = userid;
		 
		this.name = name;
		cr = new Credentials(login, pw);
	}

	public String getIDuser() {
		return IDuser;
	}

	public void setIDuser(String iDuser) {
		IDuser = iDuser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Credentials getCr() {
		return cr;
	}

	public String getlogin() {
		return cr.getLogin();
	}
	public String getpass() {
		return cr.getPw();
	}

}
