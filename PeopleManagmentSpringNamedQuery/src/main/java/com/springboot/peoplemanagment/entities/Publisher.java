package com.springboot.peoplemanagment.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@NamedQueries(value= {
		@NamedQuery(name="Publisher.findAllPublishersById",
		query="SELECT p FROM Publisher p INNER Join p.books b where p.id=?1"),
		
		
		@NamedQuery(name="Publisher.findAllPublishersByBook",
		query="SELECT p FROM Publisher p INNER Join p.books b where b.id=?1"),
		
		
		
		
	})

public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pubId;

	private String name;

	@ManyToMany(mappedBy = "publishers",fetch = FetchType.EAGER)
	private Set<Book> books;

	public Publisher() {

	}

	public Publisher(String name) {
		this.name = name;
	}

	public Publisher(String name, Set<Book> books) {
		this.name = name;
		this.books = books;
	}

	public int getPubId() {
		return pubId;
	}

	public void setPubId(int pubId) {
		this.pubId = pubId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		String result = String.format("Publisher [id=%d, name='%s']%n", pubId, name);
		if (books != null) {
			for (Book book : books) {
				result += String.format("Book[id=%d, name='%s']%n", book.getBookId(), book.getName());
			}
		}

		return result;
	}
}
