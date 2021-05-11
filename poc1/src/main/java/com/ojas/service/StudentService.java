package com.ojas.service;

import org.springframework.stereotype.Service;

import com.ojas.model.Address;
import com.ojas.model.Student;


public interface StudentService {

	void saveStudent(Student student,Address address);
	
	
	
}
