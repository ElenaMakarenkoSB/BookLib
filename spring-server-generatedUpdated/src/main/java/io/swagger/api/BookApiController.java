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
    BookService bookService;

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
        System.out.println("Adding Book... " + body.getTitle());
        bookService.addBook(body);
        return new ResponseEntity(body, HttpStatus.OK);
    }

    public ResponseEntity<List<Book>> getBooks() {
        System.out.println("Loading books...");
        List<Book> books = bookService.findAll();
        System.out.println("books..." + bookService.findAll());
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
        System.out.println("Deleting Book... " + isbn);
        Book book = bookService.findById(isbn);
        if (book == null) {
            System.out.println("book not found");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else bookService.deleteBookByIsbn(isbn);

        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<Book> getBookById(@ApiParam(value = "ID of book to return", required = true) @PathVariable("bookId") String isbn) {
        String accept = request.getHeader("Accept");
        System.out.println("Getting Book with isbn... " + isbn);
        Book book = bookService.findById(isbn);
        System.out.println(" Book found... " + book);
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
//TODO: body.getIsbn()-should return id, not isbn???
//    public ResponseEntity<Void> updateBook(@ApiParam(value = "Book object that needs to be added to the store", required = true) @Valid @RequestBody Book body) {
//        String accept = request.getHeader("Accept");
//        System.out.println("Updating Book... " + body.getTitle());
//        Book book = bookService.findById(body.getIsbn());
//        if (book == null) {
//            System.out.println("book not found");
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        } else bookService.updateBook(body, body.getIsbn());
//        return new ResponseEntity<Void>(HttpStatus.OK);
//    }

    public ResponseEntity<Void> updateBookIsbn(@ApiParam(value = "Book object that needs to be added to the store", required = true)@PathVariable("bookId") String isbn, @Valid @RequestBody Book body) {
        String accept = request.getHeader("Accept");
        System.out.println("Updating Book's isbn... " + body.getTitle());
        Book book = bookService.findById(isbn);
        if (book == null) {
            System.out.println("book not found");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else bookService.updateBookIsbn(isbn, body);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
