package utilities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleIdAssociationCom {

	private String userid;
	private String whatever;

	public SimpleIdAssociationCom(@JsonProperty("userid") String userid,
			@JsonProperty("device") String tagid) {
		super();
		this.userid = userid;
		this.whatever = tagid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getWhatever() {
		return whatever;
	}

	public void setWhatever(String whatever) {
		this.whatever = whatever;
	}

	

}
