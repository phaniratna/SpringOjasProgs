package com.springboot.peoplemanagment.dao;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.peoplemanagment.entities.Person;
public interface PeopleManagmentDAO extends CrudRepository<Person, Integer>{
	
	@Query(value="SELECT p FROM Person p where p.lastName=?1 OR p.email=?2")
	List<Person> findPersonInfobyFirstNameorEmail(String firstName,String email);
	
	
	@Query(value="SELECT * FROM person_table where last_name like %?1%",
			nativeQuery = true)
	List<Person> findPersonInfobyLastName(String lastName);
	
	List<Person> findByFirstName(String lastName);
	
	List<Person> findByLastName(String lastName, Pageable pageable);

	List<Person> findAll(Pageable pageable);

	List<Person> queryFirst10ByLastName(String string, Pageable pageable);


	
}
