package com.springboot.peoplemanagment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.springboot.peoplemanagment.entities.Book;
import com.springboot.peoplemanagment.entities.Person;

public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findAllDetails(int id);
	List<Book> findBookByPublisher(int publisher_id);
}
