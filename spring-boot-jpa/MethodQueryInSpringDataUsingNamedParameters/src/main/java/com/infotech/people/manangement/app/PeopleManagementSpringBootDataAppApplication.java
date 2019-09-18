package com.infotech.people.manangement.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infotech.people.manangement.app.entities.Person;
import com.infotech.people.manangement.app.service.PeopleManagementService;

@SpringBootApplication
public class PeopleManagementSpringBootDataAppApplication implements CommandLineRunner{

	@Autowired
	private PeopleManagementService peopleManagementService;
	
	public static void main(String[] args) {
		SpringApplication.run(PeopleManagementSpringBootDataAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Person> list = peopleManagementService.findByLastNameOrFirstName("Kumar","Sean");
		list.forEach(System.out::println);
	}

}
