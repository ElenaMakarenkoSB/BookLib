package io.swagger.service;

import io.swagger.model.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    List<Book> findAll();

    void deleteBookByIsbn(String isbn);

    Book findById(String isbn);

    void updateBook(Book book, String id);

    void updateBookIsbn(String isbn, Book book);
}
