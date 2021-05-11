package com.springboot.peoplemanagment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.peoplemanagment.entities.Person;
public interface PeopleManagmentDAO extends CrudRepository<Person, Integer>{
	
	@Query(value="SELECT p FROM Person p where p.lastName=?1 OR p.email=?2")
	List<Person> findPersonInfobyFirstNameorEmail(String firstName,String email);
	
	//@Query(value="SELECT p FROM Person p WHERE p.lastName=?1")
	//List<Person> findByLastName(String lastName);
	
	
	//@Query(value="SELECT p FROM Person p WHERE p.lastName=?1")
	@Query(value="SELECT * FROM person_table where last_name like %?1%",
			nativeQuery = true)
	List<Person> findPersonInfobyLastName(String lastName);
	
	List<Person> findByFirstName(String lastName);
	//@Query(value="SELECT * FROM person_table WHERE last_name=?1 or email=?2")

	//List<Person> findByLastNameOrFirstName(String lastName,String firstName);

	
}
