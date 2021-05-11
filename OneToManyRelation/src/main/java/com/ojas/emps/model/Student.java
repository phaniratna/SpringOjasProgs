package com.ojas.emps.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="student_info")
public class Student {
	@Id
   private int rollNo;
   private String name;
   private int marks;
   @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "laptop_id")
   private Laptop laptop;
   public Student() {
	   
   }
   public Student(int rollNo,String name,int marks,Laptop laptop) {
	   this.rollNo = rollNo;
	   this.name = name;
	   this.marks = marks;
	  this.laptop = laptop; 
   }
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	
 
}
