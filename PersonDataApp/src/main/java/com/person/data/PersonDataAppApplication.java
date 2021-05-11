package com.person.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.person.data.domain.Person;
import com.person.data.service.PersonService;

@SpringBootApplication
public class PersonDataAppApplication 
implements CommandLineRunner {

	@Autowired
	private PersonService service;

	public static void main(String[] args) {
		SpringApplication.run(PersonDataAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//createPersons();
		//findByLastName();
		findByFirstNameOrLastName();
	}
	
	private void findByLastName() {
		List<Person> personList= service.findByLastName("kumar");
		for (Person person : personList) {
			System.out.println(person.toString());
		}
				
	}
	
	private void findByFirstNameOrLastName() {
		List<Person> personList= 
		service.findByFirstNameOrLastName("RamKiran","kumar");
		for (Person person : personList) {
			System.out.println(person.toString());
		}
		
		
		
	}

	private void createPersons() {

		List<Person> personList = Arrays.asList(
		new Person("Kiran", "kumar", "kiran@gmail.com", 20),
		new Person("Ram", "kumar", "ram@gmail.com", 22),
	new Person("RamKiran", "LaxmiKiran", "sita@gmail.com", 30),
		new Person("Lakshamn", "Seth", "seth@gmail.com", 50),
		new Person("Sita", "Kumar", "lakshman@gmail.com", 50),
		new Person("Ganesh", "Kumar", "ganesh@gmail.com", 50));
			
		Iterable<Person> list = 
				service.savePersonsData(personList);
		for (Person person : list) {
			System.out.println("Person Object" +
		person.toString());

		}

	}
}
