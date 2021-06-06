package app.iServiceDAO;

import app.model.Ping;
import app.model.Tag;

public interface IDAOmanageTag {

	public String addTag(Tag t);

	public String deleteTag(Tag t);
	
	public String rLost(Tag t);
	
	public String rFound (Ping p);
	
	public String rRecoverd (Tag t);

	public String renameTag(Tag t, String newname);
}
