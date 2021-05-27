package controller;

import iServiceDAO.IDAOmanageTag;
import iServiceDAO.IDAOmanageTracker;
import iServiceDAO.IDAOmanageUser;
import model.Crs;
import model.Ping;
import model.Tag;
import model.Tracker;

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

	public boolean authenticate(Crs fc) {
		if (_daoManageuser.isUserValid(fc))
		return true;
		else
			return false;
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


	public void renameTag(Tag t) {
		_daoManageTag.renameTag(t);
	}

	public void deleteTag(Tag t) {
		_daoManageTag.deleteTag(t);
	}

	public void deleteTracker(Tracker tr) {
		_daoManageTracker.deleteTracker(tr);
	}

//	public void regerterTracker() {
//
//	}
}
