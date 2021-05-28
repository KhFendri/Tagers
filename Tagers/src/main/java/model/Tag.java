package model;

public class Tag {
	
	private String IDtag;
	private String IDman;
	private String IDuser;
	private String TagName;	
	private Ping lastping;
	
	public Tag(String iDtag, String iDman, String iDuser, String tagName, Ping lastping) {
		super();
		IDtag = iDtag;
		IDman = iDman;
		IDuser = iDuser;
		TagName = tagName;
		this.lastping = lastping;
	}

	public String getIDuser() {
		return IDuser;
	}

	public void setIDuser(String iDtracker) {
		IDuser = iDtracker;
	}

	public String getTagName() {
		return TagName;
	}

	public void setTagName(String tagName) {
		TagName = tagName;
	}

	public Ping getLastping() {
		return lastping;
	}

	public void setLastping(Ping lastping) {
		this.lastping = lastping;
	}

	public String getIDtag() {
		return IDtag;
	}

	public String getIDman() {
		return IDman;
	}
	
	
	
	
}
