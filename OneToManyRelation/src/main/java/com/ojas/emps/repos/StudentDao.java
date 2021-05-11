package com.ojas.emps.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.emps.model.Student;

public interface StudentDao extends JpaRepository<Student,Integer>{

}
