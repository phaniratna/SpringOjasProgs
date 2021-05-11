package com.springboot.peoplemanagment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.peoplemanagment.dao.BookRepository;
import com.springboot.peoplemanagment.dao.PublisherRepository;
import com.springboot.peoplemanagment.entities.Book;
import com.springboot.peoplemanagment.entities.Employee;
import com.springboot.peoplemanagment.entities.Person;
import com.springboot.peoplemanagment.entities.Publisher;
import com.springboot.peoplemanagment.service.PeopleManagementService;

@SpringBootApplication
public class PeopleManagmentSpringBootDataAppApplication implements CommandLineRunner {

	@Autowired
	private PeopleManagementService peopleManagementService;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private PublisherRepository publisherRepository;

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
		 //createPerson();
		// getPersonByIds();
		// deletePersonById();
		// updatePerson();
		// getPersonsByName();
		// getPersonsByFirstorLastName();
		// getPersonsByLastName();
		// findPersonInfobyFirstNameorEmail();

		// fetchByLastNameLength();

		// createEmployees();
		// findMaxSalariesbyDept();
		// getPersonsByLastName();
		// findPersonInfobyFirstNameorEmail();

		// fetchByLastNameLength();
		// saveManytoManyTableData();
		//getBookDetails();
		//findBookByPublisher();
		
		//findAllPublishers();
		
		//findAllPublishersByBook();
		//createEmployees();
		findMaxSalariesbyDept();

		//getBookDetails();
		
		//saveManytoManyTableData();
		
		//findBookByPublisher();
		
		//findAllDetails();
		//saveManytoManyTableData();
		//findAllDetails();
	}

	private void getPersonsByName() {
		List<Person> personList = peopleManagementService.getPersonsByFirstName("vijay");
		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private void getPersonsByLastName() {
		List<Person> personList = peopleManagementService.getPersonsByLastName("Seth");
		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());
		}

	}

	private void getPersonsByFirstorLastName() {
		List<Person> personList = peopleManagementService.findByLastNameAndFirstNameAllIgnoreCase("kumar", "Sita");
		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private void findPersonInfobyFirstNameorEmail() {
		List<Person> personList = peopleManagementService.findPersonInfobyFirstNameorEmail("Seth", "abc@gmail.com");
		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private void fetchByLastNameLength() {
		List<Person> personList = peopleManagementService.fetchByLastNameLength(5L);
		for (Person person : personList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private void updatePerson() {

		Person person = new Person(1, "vijaynew", "kumarnew", "vijum2@gmail.com", new Date());

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

	private void createEmployees() {
		List<Employee> empList = Arrays.asList(
				Employee.create("Ram", "Admin", 2000),
				Employee.create("Sita", "Sale", 1000), 
				Employee.create("Laxman", "IT", 4000),
				Employee.create("Gopi", "Admin", 3500), 
				Employee.create("Ganesh", "Sale", 3000),
				Employee.create("Seenu", "IT", 2500));

		Iterable<Employee> list = peopleManagementService.createEmployees(empList);
		for (Employee emp : list) {
			System.out.println("Employee Object" + emp.toString());

		}
	}

	private void findMaxSalariesbyDept() {
		System.out.println(" -- finding max salaries in Admin and IT depts  --");
		List<Object[]> list = peopleManagementService.findMaxSalariesByDept(Arrays.asList("Admin"));
		list.forEach(arr -> {
			System.out.println(Arrays.toString(arr));
		});
	}

	private void saveManytoManyTableData() {
		// save a couple of books
		
		Publisher publisherA = new Publisher("Publisher A");
		Publisher publisherB = new Publisher("Publisher B");
		Publisher publisherC = new Publisher("Publisher C");
		Book bookA = new Book("Book A", new HashSet<>(Arrays.asList(publisherA, publisherB)));
		Book bookB = new Book("Book B", new HashSet<>(Arrays.asList(publisherA, publisherC)));
		bookRepository.saveAll(Arrays.asList(bookA, bookB));

		
/*
		// save a couple of publishers
		Book bookD = new Book("Book D");
		Book bookE = new Book("Book E");
		Book bookF = new Book("Book F");
		Publisher publisherD = new Publisher("Publisher D", new HashSet<>
		(Arrays.asList(bookD, bookE)));
		Publisher publisherE = new Publisher("Publisher E", new HashSet<>
		(Arrays.asList(bookE, bookF)));
		publisherRepository.saveAll(Arrays.asList(publisherD, publisherE));
		
		*/

		/*
		 * fetch all publishers for (Publisher publisher :
		 * publisherRepository.findAll()) { System.out.println(publisher.toString()); }
		 */
	}

	private void getBookDetails() {
		List<Book> bookList = bookRepository.findAllDetails(1);
		for (Book book : bookList) {
			System.out.println("Book Object" + book.toString());
		}
	}

	
	private void findBookByPublisher() {
		List<Book> bookList = bookRepository.findBookByPublisher(1);
		for (Book book : bookList) {
			System.out.println("Book Object" + book.toString());
		}
	}
	
	
	private void findAllDetails()
	{
		List<Book> bookList = bookRepository.findAllDetails(1);
		System.out.println("books" + bookList.size());
		for (Book book : bookList) {
			System.out.println("Book Object" + book.toString());
		}
	}
	private void findAllPublishers() {
		List<Publisher> pubList = publisherRepository.findAllPublishersById(1);
		for (Publisher pub : pubList) {
			System.out.println("Publisher Object" + pub.toString());
		}
	}
	
	private void findAllPublishersByBook() {
		List<Publisher> pubList = publisherRepository.findAllPublishersByBook(2);
		for (Publisher pub : pubList) {
			System.out.println("Publisher Object" + pub.toString());
		}
	}
	
	
}
