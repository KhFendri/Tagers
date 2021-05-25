package daoPHPmyadmin;

import java.sql.Connection;

import iServiceDAO.IDAOmanageTracker;
import model.Tracker;

public class DAOtracker implements IDAOmanageTracker {

	MySingleton singleton = MySingleton.getInstance();
	Connection conn = singleton.getConn(); // establishing connection

	@Override
	public void addTracker(Tracker u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTracker(Tracker u) {
		// TODO Auto-generated method stub

	}

}
