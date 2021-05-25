package iServiceDAO;

import model.Tag;

public interface IDAOmanageTag {

	public void addTag(Tag t);

	public void deleteTag(Tag t);
	
	public void rLost(Tag t);
	
	public void rFound (Tag t);
}
