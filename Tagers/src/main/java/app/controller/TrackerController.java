package app.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import app.iServiceDAO.IDAOmanageTag;
import app.iServiceDAO.IDAOmanageTracker;
import app.iServiceDAO.IDAOmanageUser;
import app.model.Credentials;
import app.model.Ping;
import app.model.Tag;
import app.model.Tracker;
import app.model.User;
import utilities.*;

@Service
public class TrackerController {
	private IDAOmanageTracker _daoManageTracker;
	private IDAOmanageTag _daoManageTag;
	private IDAOmanageUser _daoManageuser;

	@Autowired
	public TrackerController(
			@Qualifier("DAOtracker") IDAOmanageTracker _daoManageTracker,
			@Qualifier("DAOtag") IDAOmanageTag _daoManageTag,
			@Qualifier("DAOuser") IDAOmanageUser _daoManageuser) {
		super();
		this._daoManageTracker = _daoManageTracker;
		this._daoManageTag = _daoManageTag;
		this._daoManageuser = _daoManageuser;
	}

	public String authenticate(Credentials fc) {
		String att = _daoManageuser.authentication(fc);
		// if (att == )
		// return true;
		// else
		// return false;
		return att;
	}
	
	public boolean verifyOwnershipTag (SimpleIdAssociationCom jcom) {
		return(_daoManageTag.verifyOwnershipTag(jcom));
	}
	
	public boolean verifyOwnershipTracker (SimpleIdAssociationCom jcom) {
		return(_daoManageTag.verifyOwnershipTracker(jcom));
	}

	public String addUser(User u) {
		return (_daoManageuser.addUser(u));
	}

	public String regesterTag(Tag t) {
		return (_daoManageTag.addTag(t));
	}

	public String reportLostTag(String tagid) {
		return(_daoManageTag.rLost(tagid));
	}

	public String reportFoundTag(Ping p) {
		return(_daoManageTag.rFound(p));
	}

	public String reportRecoveredTag(Tag t) {
		return(_daoManageTag.rRecoverd(t));
	}

	public String renameTag(Tag t, String newname) {
		return(_daoManageTag.renameTag(t, newname));
	}

	public String deleteTag(Tag t) {
		return(_daoManageTag.deleteTag(t));
	}

	public HashMap<String, String> pingMe (SimpleIdAssociationCom jcom) {
		return(_daoManageTag.pingMe(jcom));
	}
	
	public String deleteTracker(Tracker tr) {
		return(_daoManageTracker.deleteTracker(tr));
	}

	public String regesterTracker(Tracker tra) {
		return(_daoManageTracker.addTracker(tra));
	}
	
}
