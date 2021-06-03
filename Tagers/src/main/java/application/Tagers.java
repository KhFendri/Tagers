package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import application.daoPHPmyadmin.*;
import application.model.Credentials;

@EnableWebMvc
@SpringBootApplication

public class Tagers {

	public static void main(String[] args) {
		SpringApplication.run(Tagers.class, args);

		DAOtag daotag = new DAOtag();
		DAOtracker daotracker = new DAOtracker();
		DAOuser user = new DAOuser();

		System.out.println(user.authentication(new Credentials("mail1", "pass1")));;
	}

}
