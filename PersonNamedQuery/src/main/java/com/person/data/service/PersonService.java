package com.person.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.data.dao.PersonDao;
import com.person.data.domain.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao dao;

	public List<Person> findByLastName(String lastName) {

		// return dao.findByLastName(lastName);
		return dao.getPersonByLastName(lastName);
	}
	
	

	public List<Person> getPersonByLastNameOrEmail( 
			String email,String lastName) {
		return dao.getPersonByLastNameOrEmail(email,lastName );
	}

	public Iterable<Person> savePersonsData(List<Person> personList) {

		return dao.saveAll(personList);

	}

	public List<Person> findByFirstNameOrLastName(String firstName, String lastName) {

		return dao.findByFirstNameOrLastName(firstName, lastName);
	}

	public List<Person> findByAgeLessThan(int age) {
		return dao.findByAgeLessThan(age);
	}

	public List<Person> findByFirstNameOrLastNameAllIgnoreCase(String firstName, String lastName) {
		return dao.findByFirstNameOrLastNameAllIgnoreCase(firstName, lastName);
	}

	public List<Person> findByFirstNameLike(String firstName) {
		return dao.findByFirstNameLike(firstName);
	}

}
