package model;


import com.fasterxml.jackson.annotation.JsonProperty;


public class User {
	private String IDuser;
	private String name;
	private Credentials cr;

	public User(@JsonProperty("userid") String iDuser,
			@JsonProperty("userid") String nname,
			@JsonProperty("userid") String login,
			@JsonProperty("userpassword") String pw) {
		super();
		IDuser = iDuser;
		name = nname;
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
