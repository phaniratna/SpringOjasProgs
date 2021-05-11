package com.springboot.peoplemanagment.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.peoplemanagment.entities.Person;
public interface PeopleManagmentDAO extends CrudRepository<Person, Integer>{
	List<Person> findPersonInfobyFirstNameorEmail(String firstName,String email);
	List<Person> findByLastName(String lastName);
	List<Person> findByFirstName(String lastName);
	List<Person> findpersonbyLastName(String lastName);
	//List<Person> findByLastNameOrFirstNameAllIgnoreCase(String lastName,String firstName);
	List<Person> findByLastNameOrFirstName(String lastName,String firstName);
	List<Person> fetchByLastNameLength(Long length);
	
}
