package net.javabeat.spring.data.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javabeat.spring.data.domain.Book;
import net.javabeat.spring.data.domain.BookCategory;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer>{
	List<BookCategory> findByName(String name);
}
