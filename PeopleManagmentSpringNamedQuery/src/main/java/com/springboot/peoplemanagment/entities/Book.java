package com.springboot.peoplemanagment.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@NamedQueries(value= {
		@NamedQuery(name="Book.findAllDetails",
		query="SELECT  b FROM Book b INNER Join b.publishers p where b.bookId=?1"),
		
		@NamedQuery(name="Book.findBookByPublisher",
		query="SELECT b FROM Book b Join b.publishers p where p.id=?1")
		
	})
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	private String name;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	//@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "book_publisher", joinColumns = @JoinColumn(name = "book_id", 
	referencedColumnName = "bookId"), 
	inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "pubId"))
	private Set<Publisher> publishers;

	public Book() {

	}

	public Book(String name) {
		this.name = name;
	}

	public Book(String name, Set<Publisher> publishers) {
		this.name = name;
		this.publishers = publishers;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Publisher> getPublishers() {
		return publishers;
	}

	public void setPublishers(Set<Publisher> publishers) {
		this.publishers = publishers;
	}

	@Override
	public String toString() {
		String result = String.format("Book [id=%d, name='%s']%n", bookId, name);
		if (publishers != null) {
			for (Publisher publisher : publishers) {
				result += String.format("Publisher[id=%d, name='%s']%n", publisher.getPubId(), 
						publisher.getName());
			}
		}

		return result;
	}
}
