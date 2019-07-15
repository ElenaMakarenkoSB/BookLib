package io.swagger.service;

import io.swagger.model.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);
    List<Book> findAll();
    void deleteBookByIsbn(String isbn);
    Book findById(String id);
    void updateBook(Book book);
    void updateBookIsbn(Book book, String isbn);
}
