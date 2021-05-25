package model;

public class Tag {
	
	private String IDtag;
	private String IDman;
	private String IDtracker;
	private String TagName;	
	private Ping lastping;
	
	public Tag(String iDtag, String iDman, String iDtracker, String tagName, Ping lastping) {
		super();
		IDtag = iDtag;
		IDman = iDman;
		IDtracker = iDtracker;
		TagName = tagName;
		this.lastping = lastping;
	}

	public String getIDtracker() {
		return IDtracker;
	}

	public void setIDtracker(String iDtracker) {
		IDtracker = iDtracker;
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
