package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tag {

	private String IDtag;
	private String IDman;
	private String IDuser;
	private String TagName;
	private Ping lastping;

	public Tag(@JsonProperty("tagid") String iDtag,
			@JsonProperty("manid") String iDman,
			@JsonProperty("userid") String iDuser,
			@JsonProperty("tagname") String tagName,
			@JsonProperty("X") Float X,
			@JsonProperty("Y") Float Y
			) {
		super();
		
		IDtag = iDtag;
		IDman = iDman;
		IDuser = iDuser;
		TagName = tagName;
		this.lastping = new Ping(iDtag, X, Y);
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
