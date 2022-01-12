package app.iServiceDAO;


import app.model.Credentials;
import app.model.User;


public interface IDAOmanageUser {
	
	public String addUser(User u);
	public String deleteUser(User u);
	public String authentication(Credentials c);
	

}
