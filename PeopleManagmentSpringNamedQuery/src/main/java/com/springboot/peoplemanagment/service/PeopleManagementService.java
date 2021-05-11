package com.springboot.peoplemanagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.peoplemanagment.dao.EmployeeRepositoryDAO;
import com.springboot.peoplemanagment.dao.PeopleManagmentDAO;
import com.springboot.peoplemanagment.entities.Employee;
import com.springboot.peoplemanagment.entities.Person;

@Service
public class PeopleManagementService {

	@Autowired
	private PeopleManagmentDAO peopleManagmentDAO;
	
	@Autowired
	private EmployeeRepositoryDAO employeeRepositoryDAO;

	public Person cretePerson(Person person) {
		return peopleManagmentDAO.save(person);

	}

	public Iterable<Person> cretePersons(List<Person> personList) {

		Iterable<Person> list = peopleManagmentDAO.saveAll(personList);
		return list;
	}

	public Iterable<Person> getPersonByIds(List<Integer> personList) {
		return peopleManagmentDAO.findAllById(personList);
	}

	public void deletePerson(Integer personId) {
		peopleManagmentDAO.deleteById(personId);
		
	}

	public void updatePerson(Person newperson) {
		peopleManagmentDAO.save(newperson);
		
		
	}

	public List<Person> getPersonsByLastName(String lastName) {
		//return peopleManagmentDAO.findByLastName(string);
		//return peopleManagmentDAO.findPersonInfobyLastName(string);
		return peopleManagmentDAO.findpersonbyLastName(lastName);
	}
	
	public List<Person> findPersonInfobyFirstNameorEmail(String firstName,
		String email) {
	
	return peopleManagmentDAO.findPersonInfobyFirstNameorEmail(firstName,email);
}
	
	
	public List<Person> getPersonsByFirstName(String string) {
		return peopleManagmentDAO.findByFirstName(string);
	}

	
	

	
	
	public List<Person> fetchByLastNameLength(Long  length) {
		return peopleManagmentDAO.fetchByLastNameLength(length);
	}
	
	public List<Person> findByLastNameAndFirstNameAllIgnoreCase(String firstName,String lastName) {
		return peopleManagmentDAO.findByLastNameOrFirstName(lastName,firstName);
	}

	public Iterable<Employee> createEmployees(List<Employee> empList) {
		// TODO Auto-generated method stub
		Iterable<Employee> list = employeeRepositoryDAO.saveAll(empList);
		return list;
	}
	
	public List<Object[]> findMaxSalariesByDept(List<String> deptNames) {
		// TODO Auto-generated method stub
		return employeeRepositoryDAO.findMaxSalariesByDept(deptNames);
		
	}
	
	


}
