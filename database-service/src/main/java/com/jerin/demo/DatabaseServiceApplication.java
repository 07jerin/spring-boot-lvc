package com.jerin.demo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseServiceApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DatabaseServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseServiceApplication.class, args);
	}
	
	@Autowired
	private BookRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		log.info("Db operation started, check DB server for updates");
		repository.save(new Book("Golang"));
		repository.save(new Book("Java"));
		repository.save(new Book("Javascript"));
		repository.save(new Book("Python"));
		repository.save(new Book("spark"));
		
		System.out.println("\n find All method call");
		repository.findAll().forEach(x -> System.out.println(x));
		
		System.out.println("\n Find by ID");
		repository.findById(1L).ifPresent(System.out :: println);
		
		System.out.println("\n Find by Name");
		repository.findByName("Java").forEach(System.out :: println);
		
		System.out.println("\nUpdate 2");
		repository.findById(2L).ifPresent( b -> {
			b.setName("Basic Java 16");
			repository.save(b);
		});
		
//		repository.deleteById(1L);
//		repository.deleteAllById(Arrays.asList(3l,2l));
		
		System.out.println("\nDelete by Name");
		repository.findByName("spark")
			.forEach(b -> repository.delete(b));
		
		
		
		
	}

}
