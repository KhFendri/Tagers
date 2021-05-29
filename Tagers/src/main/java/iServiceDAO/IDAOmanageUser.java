package iServiceDAO;

import org.springframework.stereotype.Repository;

import model.Credentials;
import model.User;


public interface IDAOmanageUser {
	
	public void addUser(User u);
	public void deleteUser(User u);
	public String authentication(Credentials c);
	

}
