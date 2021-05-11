package com.springboot.peoplemanagment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.peoplemanagment.entities.Person;
import com.springboot.peoplemanagment.service.PeopleManagementService;

@SpringBootApplication
public class PeopleManagmentSpringBootDataAppApplication implements CommandLineRunner {

	@Autowired
	private PeopleManagementService peopleManagementService;

	public static void main(String[] args) {
		SpringApplication.run(PeopleManagmentSpringBootDataAppApplication.class, args);
	}

	private void createPerson() {
		Person person = new Person("vijay", "kumar", "vijumca@gmail.com", new Date());
		person = peopleManagementService.cretePerson(person);

	}

	@Override
	public void run(String... args) throws Exception {
		// createPersons();
		// createPersons();
		// getPersonByIds();
		//deletePersonById();
		//updatePerson();
		//getPersonsByName();
		//getPersonsByFirstorLastName();
		getPersonsByLastName();
		findPersonInfobyFirstNameorEmail();
	}
	
	private void getPersonsByName()
	{
		List<Person> personList=peopleManagementService.
				getPersonsByFirstName("vijay");
		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());

		}
		
	}
	
	private void getPersonsByLastName()
	{
		List<Person> personList=peopleManagementService.
				getPersonsByLastName("vijay");
		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());
		}
	
	}
	
	/*
	 * private void getPersonsByFirstorLastName() { List<Person>
	 * personList=peopleManagementService.
	 * findByLastNameAndFirstNameAllIgnoreCase("kumar","Sita"); for (Person person :
	 * personList) { System.out.println("Person Object" + person.toString());
	 * 
	 * }
	 * 
	 * }
	 */
	
	private void findPersonInfobyFirstNameorEmail()
	{
		List<Person> personList=peopleManagementService.
				findPersonInfobyFirstNameorEmail("vijay","lakshman@gmail.com");
		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());

		}
		
	}
	
	private void updatePerson() {

		Person person = new Person(1,"vijaynew", "kumarnew", 
				"vijumcanew1@gmail.com", new Date());
		
		peopleManagementService.updatePerson(person);

	}
	

	private void deletePersonById() {

		peopleManagementService.deletePerson(3);

	}

	private void getPersonByIds() {
		List<Integer> personList = new ArrayList<Integer>();
		personList.add(1);
		personList.add(2);
		personList.add(3);
		personList.add(4);
		personList.add(20);
		Iterable<Person> personsList = peopleManagementService.getPersonByIds(personList);
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void createPersons() {
		List<Person> personList = Arrays.asList(new Person("Kiran", "kumar", "kiran@gmail.com", new Date()),
				new Person("Ram", "kumar", "abc@gmail.com", new Date()),
				new Person("Sita", "Laxmi", "sita@gmail.com", new Date()),
				new Person("Lakshamn", "Seth", "lakshman@gmail.com", new Date()));

		Iterable<Person> list = peopleManagementService.cretePersons(personList);
		for (Person person : list) {
			System.out.println("Person Object" + person.toString());

		}

	}

}
