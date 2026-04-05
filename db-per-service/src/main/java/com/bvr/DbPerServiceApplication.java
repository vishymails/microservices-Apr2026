package com.bvr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bvr.models.Book;
import com.bvr.repositories.BookRepository;

@SpringBootApplication
public class DbPerServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DbPerServiceApplication.class, args);
	}
	
	private static final Logger log = LoggerFactory.getLogger(DbPerServiceApplication.class);
	
	@Autowired
	private BookRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		log.info("Book DB Application Started");

		log.info("CREATE BOOKS");

		repository.save(new Book("Javascript"));
		repository.save(new Book("Java"));
		repository.save(new Book("Python"));
		repository.save(new Book("C++"));
		repository.save(new Book("C#"));
		repository.save(new Book("Go"));
		repository.save(new Book("Ruby"));
		repository.save(new Book("PHP"));

		log.info("Books Created");

		log.info("FIND ALL BOOKS");

		repository.findAll().forEach(book -> log.info(book.toString()));

		log.info("FIND BOOK BY ID");
		repository.findById(1L).ifPresent(book -> log.info(book.toString()));

		log.info("FIND BOOK BY NAME");
		repository.findByName("Java").forEach(book -> log.info(book.toString()));

		log.info("UPDATE BOOK");
		repository.findById(1L).ifPresent(book -> {
			book.setName("JavaScript 2026");
			repository.save(book);
			log.info("Book Updated: " + book.toString());


		});

		log.info("FIND ALL BOOKS");

		repository.findAll().forEach(book -> log.info(book.toString()));

		log.info("DELETE BOOK");
		repository.deleteById(1L);
		log.info("Book Deleted");

		log.info("FIND ALL BOOKS");
		repository.findAll().forEach(book -> log.info(book.toString()));
	}
	
	

}
