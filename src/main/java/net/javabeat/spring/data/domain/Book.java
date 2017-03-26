package net.javabeat.spring.data.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQuery(name="Book.findByPrice",query="select name,author,price from Book b where b.price=?1")
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	long id;
	@Column(name="name")
	String name;
	@Column(name="author")
	String author;
	@Column(name="price")
	long price;	
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_category_id")
    private BookCategory bookCategory;
    
    public Book() {

    }

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, BookCategory bookCategory) {
        this.name = name;
        this.bookCategory = bookCategory;
    }
    
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
}
