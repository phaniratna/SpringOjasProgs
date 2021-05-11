package com.springboot.peoplemanagment.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.peoplemanagment.entities.Employee;

import java.util.List;

public interface EmployeeRepositoryDAO extends CrudRepository<Employee, Long> {
	public List<Object[]> findMaxSalariesByDept(List<String> deptNames);
	
	
	
}
