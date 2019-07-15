package io.swagger.repository;

import io.swagger.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
<<<<<<< Updated upstream

public interface BookRepository extends MongoRepository<Book, String> {

    public Book findByTitle(String title);
=======
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
>>>>>>> Stashed changes
}
