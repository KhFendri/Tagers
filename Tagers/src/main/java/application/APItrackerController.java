package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controller.TrackerController;
import model.Credentials;

@RestController
@RequestMapping(value="/api/tracker")
public class APItrackerController {

	private TrackerController trackerManager;

	@Autowired
	public APItrackerController(TrackerController trackerManager) {
		super();
		this.trackerManager = trackerManager;

	}
	

	@PostMapping
	public void authenticate(@RequestBody Credentials crs) {
		trackerManager.authenticate(crs);
	}
}
