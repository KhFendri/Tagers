package utilities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleStringCom {

	
	private String text;

	public SimpleStringCom(@JsonProperty("text")String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
