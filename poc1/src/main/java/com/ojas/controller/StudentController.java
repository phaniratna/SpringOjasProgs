package com.ojas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.model.Address;
import com.ojas.model.Student;
import com.ojas.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addStudent")
	public ResponseEntity<String> saveData(@RequestBody Student student,@RequestBody Address address){
		studentService.saveStudent(student, address);
		return new ResponseEntity<String>("Hello",HttpStatus.ACCEPTED);
		
	}
	

}
