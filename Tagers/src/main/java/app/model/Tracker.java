package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tracker {
	private String IDtracker;
	private String os;
	private String userID;
	private String manID;

	public Tracker(@JsonProperty("trackerid") String iDtracker,
			@JsonProperty("os") String os,
			@JsonProperty("userid") String userID,
			@JsonProperty("manid") String manID) {
		super();
		IDtracker = iDtracker;
		this.os = os;
		this.userID = userID;
		this.manID = manID;

	}

	public String getIDtracker() {
		return IDtracker;
	}

	public void setIDtracker(String iDtracker) {
		IDtracker = iDtracker;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getManID() {
		return manID;
	}

	public void setManID(String manID) {
		this.manID = manID;
	}

}
