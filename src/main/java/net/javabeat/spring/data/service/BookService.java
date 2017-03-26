package net.javabeat.spring.data.service;

import java.util.List;
import java.util.Set;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;

import net.javabeat.spring.data.domain.Book;

public interface BookService {
	public List<Book> findAll();
	public void saveBook(Book book);
	
	@Cacheable ("books")
	public Book findOne(long id);
	public void delete(long id);
	public List<Book> findByName(String name);
	public List<Book> findByNameAndAuthor(String name, String author);
	public List<Book> findByPrice(long price);
	List<Book> findByPriceRange(long price1, long price2, int limit);
	List<Book> findByNameMatch(String name);
	List<Book> findByNamedParam(String name, String author, long price);
	Set<Book> findByCategory(String name);
	public void deleteByName(String name);
	public Book saveBook(int id, String name, String author,
			long price, String category);
}
