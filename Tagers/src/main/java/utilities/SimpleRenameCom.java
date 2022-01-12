package utilities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleRenameCom {

	private String tagid;
	private String userid;
	private String newname;
	public SimpleRenameCom(@JsonProperty("tadid") String tagid,
			@JsonProperty("userid") String userid,
			@JsonProperty("newname") String newname) {
		super();
		this.tagid = tagid;
		this.userid = userid;
		this.newname = newname;
	}
	public String getTagid() {
		return tagid;
	}
	public void setTagid(String tagid) {
		this.tagid = tagid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNewname() {
		return newname;
	}
	public void setNewname(String newname) {
		this.newname = newname;
	}

}
