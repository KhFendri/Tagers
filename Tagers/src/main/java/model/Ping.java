package model;

import java.text.SimpleDateFormat;

public class Ping {
	
	private float X;
	private float Y;
	private float date;
	public Ping(float x, float y) {
		super();
		X = x;
		Y = y;
		this.date = System.currentTimeMillis();
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

	@Override
	public String toString() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		return "Ping [date=" + formatter.format(date) + "]";
	}
	
	
	
	
}
