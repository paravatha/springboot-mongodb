package org.springframework.springboot;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.springboot.domain.Book;

public interface BookRepository extends MongoRepository<Book, String> {

    public Book findByTitle(String title);
    public List<Book> findByLanguage(String language);
}
