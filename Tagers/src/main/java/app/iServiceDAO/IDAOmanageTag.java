package app.iServiceDAO;

import java.util.HashMap;

import app.model.Ping;
import app.model.Tag;
import utilities.SimpleIdAssociationCom;

public interface IDAOmanageTag {

	public boolean verifyOwnershipTag(SimpleIdAssociationCom st);
	
	public boolean verifyOwnershipTracker(SimpleIdAssociationCom st);

	public String addTag(Tag t);

	public String deleteTag(Tag t);

	public String rLost(String tagid);

	public String rFound(Ping p);

	public String rRecoverd(Tag t);
	
	public HashMap<String, String> pingMe (SimpleIdAssociationCom jcom);

	public String renameTag(Tag t, String newname);
}
