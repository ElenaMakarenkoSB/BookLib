package io.swagger.api;

import io.swagger.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-04T12:30:58.278Z")

@Controller
public class BookApiController implements BookApi {
    @Autowired
    private BookService bookService;

    private static final Logger log = LoggerFactory.getLogger(BookApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BookApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addBook(@ApiParam(value = "Book object that needs to be added to the store", required = true) @Valid @RequestBody Book body) {
        String accept = request.getHeader("Accept");
        log.info("Adding book with title [{}]", body.getTitle());
        bookService.addBook(body);
        return new ResponseEntity(body, HttpStatus.OK);
    }

    public ResponseEntity<List<Book>> getBooks() {
        System.out.println("Loading books...");
        List<Book> books = bookService.findAll();
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(books, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Book>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteBook(@ApiParam(value = "Book id to delete", required = true) @PathVariable("bookId") String isbn, @ApiParam(value = "") @RequestHeader(value = "api_key", required = false) String apiKey) {
        String accept = request.getHeader("Accept");
        log.info("Deleting book ...");
        Book book = bookService.findById(isbn);
        if (book == null) {
            log.info("book with id %s not found", book.getId());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else bookService.deleteBookByIsbn(isbn);

        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<Book> getBookById(@ApiParam(value = "ID of book to return", required = true) @PathVariable("bookId") String isbn) {
        String accept = request.getHeader("Accept");
        log.info("Getting book with isbn.."+ isbn);
        Book book = bookService.findById(isbn);
        log.info("Book found..." + book);
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(bookService.findById(isbn), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Book>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Book>(HttpStatus.OK);
    }

    public ResponseEntity<Book> updateBook(@ApiParam(value = "Book object that needs to be added to the store", required = true) @Valid @RequestBody Book body) {

        String accept = request.getHeader("Accept");
        System.out.println("Updating Book... " + body.getTitle());
        return new ResponseEntity(bookService.updateBook(body), HttpStatus.OK);
    }

    public ResponseEntity<Book> updatePartially(@ApiParam(value = "Book object that needs to be added to the store", required = true) @PathVariable("bookId") String id, @Valid @RequestBody Book body) {
        String accept = request.getHeader("Accept");
        System.out.println("Updating Book's title... " + body.getId());
        Book book = bookService.findById(id);
        if (book == null) {
            System.out.println("book not found");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Book newBook = bookService.updatePartially(body, id);

        return new ResponseEntity<Book>(newBook, HttpStatus.OK);
    }
}