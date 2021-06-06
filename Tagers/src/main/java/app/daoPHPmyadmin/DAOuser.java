package app.daoPHPmyadmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import app.iServiceDAO.IDAOmanageUser;
import app.model.Credentials;
import app.model.User;

@Repository("DAOuser")
public class DAOuser implements IDAOmanageUser {
	MySingleton singleton = MySingleton.getInstance();
	Connection conn = singleton.getConn(); // establishing connection

	@Override
	public void addUser(User u) {
		String idUser = u.getIDuser();
		String name = u.getName();
		String mail = u.getlogin();
		String pw = u.getpass();
		try {
			Statement ps;
			// ResultSet rs;
			String requete = "INSERT INTO user (IDuser, nameUser,Mail,Password)" + " VALUES ('" + idUser + "' , '"
					+ name + "' , '" + mail + "' , '" + pw + "')";
			ps = conn.createStatement();
			ps.executeUpdate(requete);

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		}

	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public String authentication(Credentials c) {
		String login = c.getLogin();
		String pw = c.getPw();

		String userid = null;
		String truepass = null;

		try {

			Statement ps;
			ResultSet rs;
			String requete = "SELECT `IDuser`,`Password` FROM `user` WHERE `Mail` ='" + (String)login + "'";
			ps = conn.createStatement();
			rs = ps.executeQuery(requete);
			while (rs.next()) {
				userid = rs.getString("IDuser");
				truepass = rs.getString("Password");

			}
			if (userid== null)
				return ("user not found");
			rs.close();
			ps.close();

		} catch (SQLException e) {
			return("user not found");
		}

		if (truepass.equals(pw)) {
			return userid;
		} else {
			return ("invalid password");

		}

	}

}
