package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import app.daoPHPmyadmin.*;
import app.model.Credentials;
import app.model.Tag;
import app.controller.*;

@EnableWebMvc
@SpringBootApplication

public class Tagers {

	public static void main(String[] args) {
		SpringApplication.run(Tagers.class, args);

//		DAOtag daotag = new DAOtag();
//		DAOtracker daotracker = new DAOtracker();
//		DAOuser daouser = new DAOuser();

//		TrackerController ac = new TrackerController(daotracker, daotag,
//				daouser);

//		String t = ac.reportLostTag(
//				new Tag("tag_id_defused_from_tag_via_bluetooth_1",
//						"samsungid22", "35b5f3f8-003f-430f-889b-0bf3295bdee0",
//						"backbag1",null,null));
//		System.out.println(t);
		

	}

}
