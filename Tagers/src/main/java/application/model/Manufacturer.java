package application.model;

public class Manufacturer {
	private String IDman;
	private String NameMan;

	public Manufacturer(String iDman, String nameMan) {
		super();
		IDman = iDman;
		NameMan = nameMan;
	}

	public String getIDman() {
		return IDman;
	}

//	public void setIDman(String iDman) {
//		IDman = iDman;
//	}

	public String getNameMan() {
		return NameMan;
	}

	public void setNameMan(String nameMan) {
		NameMan = nameMan;
	}

}
