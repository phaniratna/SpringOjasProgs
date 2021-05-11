package com.person.data.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="book_name")
	private String bookName;
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="book_publisher",
	joinColumns = @JoinColumn(name="book_id",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="publisher_id",referencedColumnName = "id"))
	private Set<Publisher> publishers;

	public Book(String bookName)
	{
		this.bookName = bookName;
	}

	public Book(String bookName, Set<Publisher> publishers) {
		super();
		this.bookName = bookName;
		this.publishers = publishers;
	}

	public Book(){	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public Set<Publisher> getPublishers() {
		return publishers;
	}


	public void setPublishers(Set<Publisher> publishers) {
		this.publishers = publishers;
	}
	
	
	
	

}
