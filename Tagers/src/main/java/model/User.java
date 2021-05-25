package model;

public class User {
	private String IDuser;
	private String name;

	public User(String iDuser, String iDtracker) {
		super();
		IDuser = iDuser;
		name = iDtracker;
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

}
