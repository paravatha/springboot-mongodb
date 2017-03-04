package org.springframework.springboot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.springboot.domain.Book;
import org.springframework.springboot.domain.Publisher;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * @author Prasad Paravatha
 * Spring Boot Application with MongoDB 
 */
@SpringBootApplication
public class App extends AbstractMongoConfiguration implements CommandLineRunner {
	@Autowired
	private BookRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	public void run(String... args) throws Exception {
		repository.deleteAll();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Publisher jonathanCape = new Publisher("Jonathan Cape", 1920, "New York");
		jonathanCape.setPubId("jonathanCape");

		Publisher hamishHamilton = new Publisher("Hamish Hamilton", 1896, "New York");
		hamishHamilton.setPubId("hamishHamilton");		
		
		Book midnightsChildren = new Book("Midnights Children", "Salman Rushdie", sdf.parse("1985-02-11"), 446, "English", jonathanCape);
		Book whiteTeeth = new Book("White Teeth", "Zadie Smith", sdf.parse("2000-01-27"), 480, "English", hamishHamilton);
		
		// save books
		repository.save(midnightsChildren);
		repository.save(whiteTeeth);
		
		// fetch all books
		System.out.println("Books found with findAll():");
		System.out.println("-------------------------------");
		for (Book book : repository.findAll()) {
			System.out.println(book);
		}
		System.out.println();		
		
		// fetch an individual book
		System.out.println("Books found with findByTitle('Midnights Children'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByTitle("Midnights Children"));
		System.out.println();	
		
		// fetch books in English
		System.out.println("Books found with findByLanguage('English'):");
		System.out.println("--------------------------------");
		for (Book book : repository.findByLanguage("English")) {
			System.out.println(book);
		}
		System.out.println();

		// fetch books by Publisher Name
		System.out.println("Books found with find by Publisher Name - 'Jonathan Cape'");
		System.out.println("--------------------------------");
    	Publisher probePublisher = new Publisher("Jonathan Cape", null, null);    	
    	Book probeBook = new Book(probePublisher);
		for (Book book : repository.findAll(Example.of(probeBook))) {
			System.out.println(book);
		}
		System.out.println();
	}

	@Override
	protected String getDatabaseName() {
		return "mytest";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost" , 27017 );
	}
	
}
