package io.swagger.repository;

import io.swagger.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

    public Book findByTitle(String title);
}
