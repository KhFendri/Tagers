package controller;

import iServiceDAO.IDAOmanageTag;
import iServiceDAO.IDAOmanageTracker;
import iServiceDAO.IDAOmanageUser;
import model.Crs;
import model.Ping;
import model.Tag;
import model.Tracker;
import model.User;

public class TrackerManager {
	IDAOmanageTracker _daoManageTracker;
	IDAOmanageTag _daoManageTag;
	IDAOmanageUser _daoManageuser;

	public TrackerManager(IDAOmanageTracker _daoManageTracker, IDAOmanageTag _daoManageTag,
			IDAOmanageUser _daoManageuser) {
		super();
		this._daoManageTracker = _daoManageTracker;
		this._daoManageTag = _daoManageTag;
		this._daoManageuser = _daoManageuser;
	}

	public String authenticate(Crs fc) {
		String att =_daoManageuser.authentication(fc);
//		if (att == )
//			return true;
//		else
//			return false;
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
