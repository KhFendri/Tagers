package app.model;

import java.text.SimpleDateFormat;

public class Ping {
	
	private String tagID;
	private float X;
	private float Y;
	private float date;
	public Ping(String tid ,float x, float y) {
		super();
		tagID= tid;
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


	public String toStringDate() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		return "Ping [date=" + formatter.format(date) + "]";
	}


	@Override
	public String toString() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		return "Ping [tID=" + tagID + ", X=" + X + ", Y=" + Y + ", date=" + formatter.format(date) + "]";
	}
	
	
	
	
	
}