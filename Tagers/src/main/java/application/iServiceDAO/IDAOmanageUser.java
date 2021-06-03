package application.iServiceDAO;

import org.springframework.stereotype.Repository;

import application.model.Credentials;
import application.model.User;


public interface IDAOmanageUser {
	
	public void addUser(User u);
	public void deleteUser(User u);
	public String authentication(Credentials c);
	

}
