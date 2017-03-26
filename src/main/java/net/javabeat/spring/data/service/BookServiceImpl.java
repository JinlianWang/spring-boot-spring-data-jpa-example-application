package net.javabeat.spring.data.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javabeat.spring.data.domain.Book;
import net.javabeat.spring.data.domain.BookCategory;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookOwnRepository bookOwnRepository;
	@Autowired
	private BookQueryRepositoryExample bookQueryRepository;
	@Autowired
	private BookNamedQueryRepositoryExample bookNamedQueryRepository;	

	@Autowired
	private BookCategoryRepository bookCategoryRepository;
	
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public List<Book> findByName(String name) {
		return bookQueryRepository.findByName(name);
	}

	public List<Book> findByNameMatch(String name) {
		return bookQueryRepository.findByNameMatch(name);
	}

	public List<Book> findByNamedParam(String name, String author, long price) {
		return bookQueryRepository.findByNamedParam(name, author, price);
	}

	public List<Book> findByPriceRange(long price1, long price2, int limit) {
		return bookQueryRepository.cool(price1, price2, limit);
	}

	public List<Book> findByPrice(long price) {
		return bookNamedQueryRepository.findByPrice(price);
	}

	public List<Book> findByNameAndAuthor(String name, String author) {
		return bookOwnRepository.findByNameAndAuthor(name, author);
	}

	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	public Book findOne(long id) {
		System.out.println("Cached Pages");
		return bookRepository.findOne(id);
	}

	public void delete(long id) {
		bookRepository.delete(id);
	}
	
	public void deleteByName(String name) {
		List<Book> list = this.findByName(name);
		if(list.size() > 0) {
			bookRepository.delete(list.get(0));
		}
	}
	
	public Set<Book> findByCategory(String name) {
		List<BookCategory> catList = this.bookCategoryRepository.findByName(name);
		if(catList.size()>0){
			return catList.get(0).getBooks();
		}
		return null;
	}
	
	public Book saveBook(int id, String name, String author,
			long price, String category){
		BookCategory cat = null;
		List<BookCategory> catList = this.bookCategoryRepository.findByName(category);
		if(catList.size()>0){
			cat = catList.get(0);
		} else {
			cat = new BookCategory(category);
		}
		Book book = new Book();
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		book.setPrice(price);
		book.setBookCategory(cat);
		this.saveBook(book);
		return book;
	}
}
