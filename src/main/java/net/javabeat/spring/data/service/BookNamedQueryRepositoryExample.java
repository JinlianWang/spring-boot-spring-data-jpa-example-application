package net.javabeat.spring.data.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import net.javabeat.spring.data.domain.Book;

public interface BookNamedQueryRepositoryExample extends Repository<Book, Long> {
	// Query will be used from Named query defined at Entity class
	//@Query(value="select author, name, price from Book b where b.price > ?1")
	List<Book> findByPrice(long price);
}
