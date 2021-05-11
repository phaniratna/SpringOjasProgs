package com.springboot.peoplemanagment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.springboot.peoplemanagment.entities.Book;
import com.springboot.peoplemanagment.entities.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

	
	List<Publisher> findAllPublishersById(int publisher_id);
	
	List<Publisher> findAllPublishersByBook(int book_id);
}
