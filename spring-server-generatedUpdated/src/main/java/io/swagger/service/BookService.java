package io.swagger.service;

import io.swagger.model.Book;
import io.swagger.model.ModelApiResponse;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    List<Book> findAll();

    void deleteBookByIsbn(String isbn);

    Book findById(String isbn);

    ModelApiResponse updateBook(Book book);

    Book updatePartially(Book book, String id);
}
