package io.swagger.service;

import io.swagger.model.Book;
import io.swagger.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookServiceImp implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBookByIsbn(String isbn) {
        bookRepository.delete(isbn);
    }

    @Override
    public Book findById(String id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBookIsbn(Book book, String isbn) {
        bookRepository.save(book);
    }

}
