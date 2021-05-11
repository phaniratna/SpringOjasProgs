package com.person.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="person_table")
@NamedQueries(value= {
	@NamedQuery(name="person.getPersonByLastName",
			query = "SELECT p from Person p where p.lastName=?1"),
	
	@NamedQuery(name="person.getPersonByLastNameOrEmail",
	query = "SELECT p from Person p where p.email=?1 or p.lastName=?2")	
		
})
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="person_id")
	private int id;
	
	
	@Column(name="first_name",nullable = false)
	private String firstName;
	
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email",unique = true)
	private String email;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="age")
	private int age;

	public Person() {}
	
	
	public Person( String firstName, String lastName, String email,  int age) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creationDate = new Date();
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", creationDate=" + creationDate + ", age=" + age + "]";
	}
	
	

}
