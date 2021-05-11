package com.person.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.person.data.domain.Person;

@Repository
public interface PersonDao  extends JpaRepository<Person, Integer>{
	
	List<Person> getPersonByLastName(String lastName);
	
	List<Person> getPersonByLastNameOrEmail(String email,String lastName);
	
	List<Person> findByLastName(String lastName);
	
	List<Person> findByFirstNameOrLastName(String firstName,String lastName);

	List<Person> findByAgeLessThan(int age);//-> Abstract Method
	
	List<Person> findByFirstNameOrLastNameAllIgnoreCase
			(String firstName,String lastName);
	
	List<Person> findByFirstNameLike(String firstName);
}
