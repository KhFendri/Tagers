package iServiceDAO;

import model.Crs;
import model.User;

public interface IDAOmanageUser {
	
	public void addUser(User u);
	public void deleteUser(User u);
	public String authentication(Crs c);
	

}
