package app.iServiceDAO;

import org.springframework.stereotype.Repository;

import app.model.Credentials;
import app.model.User;


public interface IDAOmanageUser {
	
	public void addUser(User u);
	public void deleteUser(User u);
	public String authentication(Credentials c);
	

}
