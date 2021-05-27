package application;

import controller.TrackerManager;
import model.*;
import daoPHPmyadmin.*;

public class main {

	public static void main(String[] args) {
		DAOtag daotag = new DAOtag();
		DAOtracker daotracker = new DAOtracker();
		DAOuser user = new DAOuser();
		TrackerManager trm = new TrackerManager(daotracker, daotag, user);
		
		trm.regesterTag(new Tag("idtag1", "samsungidman222", "trackerid1", "backbag", new Ping("idtag1", 1, 11) ));
		
	}

}
