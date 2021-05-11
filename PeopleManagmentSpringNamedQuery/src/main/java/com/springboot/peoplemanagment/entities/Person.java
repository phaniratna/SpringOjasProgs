package com.springboot.peoplemanagment.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "person_table")
//@DynamicUpdate
@NamedQueries(value= {
	@NamedQuery(name="Person.findpersonbyLastName",
	query="SELECT p FROM Person p where p.lastName=?1"),
	@NamedQuery(name="Person.findPersonInfobyFirstNameorEmail",
	query="SELECT p FROM Person p where p.lastName=?1 or "
			+ "p.email=?2"),
	@NamedQuery(name = "Person.fetchByLastNameLength",
    query = "SELECT p FROM Person p where CHAR_LENGTH(p.lastName) =:length ")
	
})


public class Person {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private int id;

	@Column(name = "first_name",length = 60,nullable = false)
	private String firstName;

	@Column(name = "last_name",length = 60,nullable = false)
	private String lastName;

	@Column(name = "email",unique = true)
	private String email;

	@Column(name = "creation_date")
	private Date creationDate;

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

	public Person(){
		
	}
			
	public Person( String firstName, String lastName, String email, Date creationDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creationDate = creationDate;
	}
	
	public Person(Integer id,String firstName, String lastName, String email, Date creationDate) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creationDate = creationDate;
	}
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", creationDate=" + creationDate + "]";
	}

}
