package com.ojas.emps.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.emps.model.Laptop;
import com.ojas.emps.model.Student;

public interface LaptopDao extends JpaRepository<Laptop,Integer>{

}
