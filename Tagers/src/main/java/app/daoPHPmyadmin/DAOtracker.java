package app.daoPHPmyadmin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import app.iServiceDAO.IDAOmanageTracker;
import app.model.Tracker;

@Repository("DAOtracker")
public class DAOtracker implements IDAOmanageTracker {

	MySingleton singleton = MySingleton.getInstance();
	Connection conn = singleton.getConn(); // establishing connection

	@Override
	public String addTracker(Tracker tra) {
		String trackerid= tra.getIDtracker();
		String trackerOS= tra.getOs();
		String userID= tra.getUserID();
		String manID= tra.getManID();
		
		try {
			Statement ps;
			// ResultSet rs;
			String requete = "INSERT INTO `Tracker` (`IDtracker`, `OS`,`IDuser`, `IDman`)" + " VALUES ('" + trackerid + "' , '"
					+ trackerOS + "' , '" + userID + "' , '" +manID+"' )";
			ps = conn.createStatement();
			ps.executeUpdate(requete);

			ps.close();
			
			return (trackerid);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
			return("error");
		}

	}

	@Override
	public String deleteTracker(Tracker tra) {
		String IDtra = tra.getIDtracker();

		try {
			Statement ps;
			// ResultSet rs;
			String requete = " DELETE FROM `Tracker` WHERE `IDtracker` ='" + IDtra + "'; ";
			ps = conn.createStatement();
			ps.executeUpdate(requete);

			ps.close();
			
			return ("deleted");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
			return ("error");
		}

	}

}
