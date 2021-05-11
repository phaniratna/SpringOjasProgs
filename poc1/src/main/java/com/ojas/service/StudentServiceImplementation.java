package com.ojas.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.ojas.model.Address;
import com.ojas.model.Student;
import com.ojas.repos.AddressDao;
import com.ojas.repos.StudentDao;

public class StudentServiceImplementation  implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private AddressDao addessDao;
	
	@Override
	public void saveStudent(Student student, Address address) {
		addessDao.save(address);
		student.setAddress(address);
        studentDao.save(student);
       
		
	}

}
