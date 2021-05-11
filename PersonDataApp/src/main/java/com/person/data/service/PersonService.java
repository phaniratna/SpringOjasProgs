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

		return dao.findByLastName(lastName);
	}

	public Iterable<Person> savePersonsData(
			List<Person> personList) {
		return dao.saveAll(personList);

	}

	public List<Person> findByFirstNameOrLastName(
			String firstName, 
			String lastName) {

		return dao.findByFirstNameOrLastName(firstName, lastName);
	}

}
