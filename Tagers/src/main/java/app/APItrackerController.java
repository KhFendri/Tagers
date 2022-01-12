package app;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import app.controller.TrackerController;
import app.daoPHPmyadmin.*;
import app.model.*;
import utilities.*;

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

	public HashMap<String, String> jsonResponse(String resp) {
		HashMap<String, String> Jres = new HashMap<>();
		Jres.put("response", resp);
		return (Jres);
	}

	@GetMapping(value = "/api/authenticate")
	public HashMap<String, String> authenticate(@RequestBody Credentials crs) {
		String resp = trackerCRTL.authenticate(crs);
		HashMap<String, String> map = new HashMap<>();
		map.put("response", resp);

		return map;

	}

	@GetMapping(value = "/api/adduser")
	public HashMap<String, String> addUser(@RequestBody User u) {
		String resp = trackerCRTL.addUser(u);

		return (jsonResponse(resp));
	}

	@GetMapping(value = "/api/regestertag")
	public HashMap<String, String> regesterTag(@RequestBody Tag t) {
		String resp = trackerCRTL.regesterTag(t);

		return (jsonResponse(resp));
	}

	@GetMapping(value = "/api/reportlosttag")
	public HashMap<String, String> reportLostTag(@RequestBody SimpleIdAssociationCom jcom) {
		String resp;
		if (trackerCRTL.verifyOwnershipTag(jcom)) {

			resp = trackerCRTL.reportLostTag(jcom.getWhatever());
		} else {
			resp = "error: you are not the owner of this tag";
		}

		return (jsonResponse(resp));
	}

	@GetMapping(value = "/api/reportfoundtag")
	public HashMap<String, String> reportFoundTag(@RequestBody Ping p) {
		String resp = trackerCRTL.reportFoundTag(p);
		return (jsonResponse(resp));
	}

	@GetMapping(value = "/api/reportrecoveredtag")
	public HashMap<String, String> reportRecoveredTag(@RequestBody SimpleIdAssociationCom jcom) {
		String resp;
		if (trackerCRTL.verifyOwnershipTag(jcom)) {
			resp = trackerCRTL.reportRecoveredTag(new Tag(jcom.getWhatever(),
					"null", jcom.getUserid(), "null", "0", "0"));
		} else {
			resp = "error: you are not the owner of this tag";
		}
		return (jsonResponse(resp));
	}

	@GetMapping(value = "/api/renametag")
	public HashMap<String, String> renameTag(@RequestBody SimpleRenameCom jcom) {
		Tag t = new Tag(jcom.getTagid(), "Null", jcom.getUserid(), "Null", "0",
				"0");
		String resp;
		if (trackerCRTL.verifyOwnershipTag(new SimpleIdAssociationCom(
				jcom.getUserid(), jcom.getTagid()))) {
			resp = trackerCRTL.renameTag(t, jcom.getNewname());
		} else {
			resp = "error: you are not the owner of this tag";
		}

		return (jsonResponse(resp));
	}

	@GetMapping(value = "/api/deletetag")
	public HashMap<String, String> deleteTag(@RequestBody SimpleIdAssociationCom jcom) {
		String resp;
		if (trackerCRTL.verifyOwnershipTag(jcom)) {
			resp = trackerCRTL.deleteTag(new Tag(jcom.getWhatever(), "null",
					jcom.getUserid(), "null", "0", "0"));
		} else {
			resp = "error: you are not the owner of this tag";
		}
		return (jsonResponse(resp));
	}

	@GetMapping(value = "/api/deletetracker")
	public HashMap<String, String> deleteTracker(@RequestBody SimpleIdAssociationCom jcom) {
		String resp;
		if (trackerCRTL.verifyOwnershipTracker(jcom)) {
			resp = trackerCRTL.deleteTracker(new Tracker(jcom.getWhatever(),
					"null", jcom.getUserid(), "null"));
		} else {
			resp = "error: you are not the owner of this tag";
		}
		return (jsonResponse(resp));
	}

	@GetMapping(value = "/api/regertertracker")
	public HashMap<String, String> regerterTracker(@RequestBody Tracker tr) {
		String resp = trackerCRTL.regesterTracker(tr);
		return (jsonResponse(resp));
	}
	
	@GetMapping(value = "/api/pingme")
	public HashMap<String, String> pingMe(@RequestBody SimpleIdAssociationCom jcom) {
		String respe;
		if (trackerCRTL.verifyOwnershipTracker(jcom)) {
			return( trackerCRTL.pingMe(jcom));
		} else {
			//respe = "error: you are not the owner of this tag";
			//return (jsonResponse(respe));
			return (trackerCRTL.pingMe(jcom));
		}
		
	}
	
}
