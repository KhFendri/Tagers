package app.model;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ping {

	private String tagID;
	private float X;
	private float Y;
	private float date;
	
	public Ping(@JsonProperty("tagid") String tid, 
			@JsonProperty("x") float x,
			@JsonProperty("y") float y) {
		super();
		tagID = tid;
		X = x;
		Y = y;
		this.date = System.currentTimeMillis();
	}

	public String gettID() {
		return tagID;
	}

	public float getX() {
		return X;
	}

	public float getY() {
		return Y;
	}

	public float getDate() {
		return date;
	}
	
	

	public void setTagID(String tagID) {
		this.tagID = tagID;
	}

	public void setX(float x) {
		X = x;
	}

	public void setY(float y) {
		Y = y;
	}

	public void setDate(float date) {
		this.date = date;
	}

	public String toStringDate() {
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd 'at' HH:mm:ss z");
		return "Ping [date=" + formatter.format(date) + "]";
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd 'at' HH:mm:ss z");
		return "Ping [tID=" + tagID + ", X=" + X + ", Y=" + Y + ", date="
				+ formatter.format(date) + "]";
	}

}
