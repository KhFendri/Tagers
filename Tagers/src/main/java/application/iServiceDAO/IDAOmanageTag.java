package application.iServiceDAO;

import application.model.Ping;
import application.model.Tag;

public interface IDAOmanageTag {

	public void addTag(Tag t);

	public void deleteTag(Tag t);
	
	public void rLost(Tag t);
	
	public void rFound (Ping p);
	
	public void rRecoverd (Tag t);

	public void renameTag(Tag t, String newname);
}
