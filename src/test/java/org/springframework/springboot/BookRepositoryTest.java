package org.springframework.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.springboot.domain.Book;
import org.springframework.springboot.domain.Publisher;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository repository;
    Book oscarWao, americanah, purity;
    Publisher alfredKnopf, macMillan;    

    @Before
    public void setUp() throws ParseException {

        repository.deleteAll();
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
		alfredKnopf = new Publisher("Alfred A. Knopf", 1985, "New York");
		alfredKnopf.setPubId("alfredKnopf");

		macMillan = new Publisher("MacMillan", 1945, "New York");
		macMillan.setPubId("macMillan");
        
		oscarWao = new Book("The Brief Wondrous Life of Oscar Wao", "Junot Diaz", simpleDateFormat.parse("2007-09-06"), 352, "English", alfredKnopf);
		americanah = new Book("Americanah", "Chimamanda Ngozi Adichie", simpleDateFormat.parse("2013-05-01"), 425, "English", alfredKnopf);
		purity = new Book("Purity", "Jonathan Franzen", simpleDateFormat.parse("2015-09-01"), 563, "English", macMillan);		
		
		oscarWao = repository.save(oscarWao);
		americanah = repository.save(americanah);
		purity = repository.save(purity);
    }

    @Test
    public void findbyTitle() {
    	Book result = repository.findByTitle("Americanah");
    	assertThat((result).getAuthor().equals("Chimamanda Ngozi Adichie"));
    }

    @Test
    public void findsBooksInEnglish() {
    	Book probe = new Book(null, null, null, null, "English", null);
        List<Book> result = repository.findAll(Example.of(probe));
        assertThat(result).hasSize(3).extracting("author").contains("Junot Diaz", "Chimamanda Ngozi Adichie", "Jonathan Franzen");
    }
    
    @Test
    public void findsBookByPublisherObject() {
    	Book probe = new Book(null, null, null, null, null, alfredKnopf);
        List<Book> result = repository.findAll(Example.of(probe));
        assertThat(result).hasSize(2).extracting("author").contains("Junot Diaz", "Chimamanda Ngozi Adichie");
    }    
    
    @Test
    public void findsBookByPublisherName() {
    	Publisher probe = new Publisher("MacMillan", null, null);    	
    	Book probeBook = new Book(null, null, null, null, null, probe);
        List<Book> result = repository.findAll(Example.of(probeBook));
        assertThat(result).hasSize(1).extracting("author").contains("Jonathan Franzen");
    }    
}
