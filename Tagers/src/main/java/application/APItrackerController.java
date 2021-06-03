package application;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import application.controller.TrackerController;
import application.model.Credentials;
import net.minidev.json.JSONObject;
import application.model.*;

import application.daoPHPmyadmin.*;

@RestController
// @RequestMapping
public class APItrackerController {

	DAOtag _daotag;
	DAOtracker _daotracker;
	DAOuser _daouser;
	private TrackerController trackerCRTL;

	// @Autowired
	// public APItrackerController() {
	// super();
	// this.trackerCRTL = new TrackerController(_daotracker , _daotag,
	// _daouser);
	//
	// }

	@Autowired
	public APItrackerController(TrackerController trackerManager) {
		super();
		this.trackerCRTL = trackerManager;

	}

	@GetMapping(value = "/api/authenticate")
	public HashMap<String, String>  authenticate(@RequestBody Credentials crs) {
		String resp = trackerCRTL.authenticate(crs);
		System.out.println(resp);
	    HashMap<String, String> map = new HashMap<>();
	    map.put("response", resp);
	   
	    return map;
		

	}

	@PostMapping(value = "/api/adduser")
	 public void addUser(@RequestBody User u) {
		trackerCRTL.addUser(u);
	
	 }
	
	@PostMapping(value = "/api/regestertag")
	 public void regesterTag(@RequestBody Tag t) {
		trackerCRTL.regesterTag(t);
	 }
	//
	// public void reportLostTag(Tag t) {
	// _daoManageTag.rLost(t);
	// }
	//
	// public void reportFoundTag(Ping p) {
	// _daoManageTag.rFound(p);
	// }
	//
	// public void reportRecoveredTag(Tag t) {
	// _daoManageTag.rRecoverd(t);
	// }
	//
	// public void renameTag(Tag t, String newname) {
	// _daoManageTag.renameTag(t, newname);
	// }
	//
	// public void deleteTag(Tag t) {
	// _daoManageTag.deleteTag(t);
	// }
	//
	// public void deleteTracker(Tracker tr) {
	// _daoManageTracker.deleteTracker(tr);
	// }
	//
	// public void regerterTracker(Tracker tra) {
	// _daoManageTracker.addTracker(tra);
	// }
}
