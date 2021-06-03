package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import application.iServiceDAO.IDAOmanageTag;
import application.iServiceDAO.IDAOmanageTracker;
import application.iServiceDAO.IDAOmanageUser;
import application.model.Credentials;
import application.model.Ping;
import application.model.Tag;
import application.model.Tracker;
import application.model.User;

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

	public void addUser(User u) {
		_daoManageuser.addUser(u);
	}

	public void regesterTag(Tag t) {
		_daoManageTag.addTag(t);
	}

	public void reportLostTag(Tag t) {
		_daoManageTag.rLost(t);
	}

	public void reportFoundTag(Ping p) {
		_daoManageTag.rFound(p);
	}

	public void reportRecoveredTag(Tag t) {
		_daoManageTag.rRecoverd(t);
	}

	public void renameTag(Tag t, String newname) {
		_daoManageTag.renameTag(t, newname);
	}

	public void deleteTag(Tag t) {
		_daoManageTag.deleteTag(t);
	}

	public void deleteTracker(Tracker tr) {
		_daoManageTracker.deleteTracker(tr);
	}

	public void regerterTracker(Tracker tra) {
		_daoManageTracker.addTracker(tra);
	}
}
