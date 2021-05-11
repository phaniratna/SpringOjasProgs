package com.person.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.person.data.dao.BookDao;
import com.person.data.dao.PublisherDao;
import com.person.data.domain.Book;
import com.person.data.domain.Person;
import com.person.data.domain.Publisher;
import com.person.data.service.PersonService;

@SpringBootApplication
public class PersonDataAppApplication implements CommandLineRunner {

	@Autowired
	private PersonService service;
	
	@Autowired
	private BookDao bookdao;
	
	@Autowired
	private PublisherDao publisherDao;

	public static void main(String[] args) {
		SpringApplication.run(PersonDataAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//createPersons();
		//findByLastName();
		//findByFirstNameOrLastName();
		
		//findByAgeLessThan();
		//findByFirstNameOrLastNameAllIgnoreCase();
		//findByFirstNameLike();
		//getPersonByLastNameOrEmail();
		saveBookPublishers();
	}
	
	
	private void findByAgeLessThan() {
		List<Person> personList= service.findByAgeLessThan(31);
		for (Person person : personList) {
			System.out.println(person.toString());
		}
	}
	
	private void findByLastName() {
		List<Person> personList= service.findByLastName("kumar");
		for (Person person : personList) {
			System.out.println(person.toString());
		}
	}
	
	private void getPersonByLastNameOrEmail() {
		List<Person> personList= service.
				getPersonByLastNameOrEmail("ram@gmail.com","kumar");
		for (Person person : personList) {
			System.out.println(person.toString());
		}
	}
	
	
	
	private void findByFirstNameOrLastName() {
		List<Person> personList= service.
				findByFirstNameOrLastName("RamKiran","kumar");
		for (Person person : personList) {
			System.out.println(person.toString());
		}
		
	}
	
	private void findByFirstNameLike() {
		List<Person> personList= service.findByFirstNameLike("%iran%");
		for (Person person : personList) {
			System.out.println(person.toString());
		}
	}
	
	
	
	
	private void findByFirstNameOrLastNameAllIgnoreCase() {
		List<Person> personList= service.
				findByFirstNameOrLastNameAllIgnoreCase
				("ramkiran","KUMAR");
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

	
		
		
		
		Iterable<Person> list = service.savePersonsData(personList);
		for (Person person : list) {
			System.out.println("Person Object" + person.toString());

		}

	}
	
	
	private void saveBookPublishers()
	{
		Publisher publisherA=new Publisher("PublisherA");
		Publisher publisherB=new Publisher("PublisherB");
		Publisher publisherC=new Publisher("PublisherC");
		
		
		
		Book bookA=new Book("BookA",
				new HashSet<>(Arrays.asList(publisherA,publisherB)));
		
		Book bookB=new Book("BookB",
				new HashSet<>(Arrays.asList(publisherA,publisherC)));
		
		bookdao.saveAll(Arrays.asList(bookA,bookB));
		
		
		
		Book bookC=new Book("BookC");
		Book bookD=new Book("BookD");
		Book bookE=new Book("BookE");
		
		//Book Table->3
		//PublishernTable ->2
		//Book_Publisher ->4
		
		//PublisherD -> Bookc
		//PublisherD -> BookD
		//publisherE -> bookD
		//publisherE -> bookE
		
		Publisher publisherD=new Publisher("PublisherD",new 
				HashSet<>(Arrays.asList(bookC,bookD)));
		
		Publisher publisherE=new Publisher("PublisherE",new 
				HashSet<>(Arrays.asList(bookD,bookE)));
		publisherDao.saveAll(Arrays.asList(publisherD,publisherE));
		
		/*
		Set<Publisher> publishersSet=new HashSet<Publisher>();
		
		publishersSet.add(publisherA);
		publishersSet.add(publisherB);
		
		Book book=new Book();
		book.setBookName("BookA");
		book.setPublishers(publishersSet);
		
		*/

		// 1-> PublisherA
		//2-> PublisherB
		//3-> PublisherC
		
		//Publisher Table -> 3
		//Book Table ->2
		//Book_Publisher -> BookA -> PublisherA
		//					BookA -> PublisherB
		//					BookB ->PublisherA
		//					BookB  ->PublisherC
		
		//Book -> 5 records
		//Publisher -> 5 records
		//Book_publisher -> 8 records
		
		
		
		
	}
}
