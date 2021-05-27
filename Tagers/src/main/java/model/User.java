package model;

public class User {
	private String IDuser;
	private String name;
	private Crs cr;

	public User(String iDuser, String nname, String login ,String pw) {
		super();
		IDuser = iDuser;
		name = nname;
		cr = new Crs(login, pw);
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

	public Crs getCr() {
		return cr;
	}
	
	public String getlogin() {
		return cr.getLogin();
	}
	public String getpass() {
		return cr.getPw();
	}

}
