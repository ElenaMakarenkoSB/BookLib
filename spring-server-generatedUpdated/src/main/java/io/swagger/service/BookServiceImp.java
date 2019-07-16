package io.swagger.service;

import io.swagger.model.Book;
import io.swagger.model.ModelApiResponse;
import io.swagger.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BookServiceImp implements BookService {
    private ModelApiResponse m = new ModelApiResponse();
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
    public Book findById(String isbn) {
        return bookRepository.findOne(isbn);
    }

    @Override
    public ModelApiResponse updateBook(Book book) {

        if (bookRepository.findOne(book.getId()) != null) {
            bookRepository.save(book);
            m.setMessage("Book has been updated");
            m.setCode(200);

        } else {
            m.setMessage("Book can't be updated");
            m.setCode(404);
        }
        return m;
    }

    @Override
    public Book updatePartially(Book book, String id) {
        Book b = findById(id);
        b.setTitle(book.getTitle());
        return bookRepository.save(b);

    }
}
