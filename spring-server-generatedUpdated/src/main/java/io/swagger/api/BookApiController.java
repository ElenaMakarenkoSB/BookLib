package io.swagger.api;

import io.swagger.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
<<<<<<< Updated upstream
=======
import io.swagger.service.BookService;
>>>>>>> Stashed changes
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
<<<<<<< Updated upstream
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> Stashed changes

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
<<<<<<< Updated upstream
import java.io.IOException;
=======
import java.util.ArrayList;
>>>>>>> Stashed changes
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-04T12:30:58.278Z")

@Controller
public class BookApiController implements BookApi {

    private static final Logger log = LoggerFactory.getLogger(BookApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BookApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

<<<<<<< Updated upstream
    public ResponseEntity<Void> addBook(@ApiParam(value = "Book object that needs to be added to the store" ,required=true )  @Valid @RequestBody Book body) {
=======
    public ResponseEntity<Void> addBook(@ApiParam(value = "Book object that needs to be added to the store", required = true) @Valid @RequestBody Book body) {
        String accept = request.getHeader("Accept");
        System.out.println("Adding Book... " + body.getTitle());
        bookService.addBook(body);
        return new ResponseEntity(body, HttpStatus.OK);
    }

    public ResponseEntity<List<Book>> getBooks() {
        System.out.println("Loading books...");
        List<Book> books = new ArrayList<>();//Arrays.asList();
        books = (List) bookService.findAll();
>>>>>>> Stashed changes
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

<<<<<<< Updated upstream
    public ResponseEntity<Void> deleteBook(@ApiParam(value = "Book id to delete",required=true) @PathVariable("bookId") Long bookId,@ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey) {
=======
    public ResponseEntity<Void> deleteBook(@ApiParam(value = "Book id to delete", required = true) @PathVariable("bookId") String isbn, @ApiParam(value = "") @RequestHeader(value = "api_key", required = false) String apiKey) {
>>>>>>> Stashed changes
        String accept = request.getHeader("Accept");
        Book book = bookService.findById(isbn);
        if (book == null) {
            System.out.println("book not found");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else bookService.deleteBookByIsbn(isbn);

        return new ResponseEntity(HttpStatus.OK);
    }

<<<<<<< Updated upstream
    public ResponseEntity<Book> getBookById(@ApiParam(value = "ID of book to return",required=true) @PathVariable("bookId") Long bookId) {
=======
    public ResponseEntity<Book> getBookById(@ApiParam(value = "ID of book to return", required = true) @PathVariable("bookId") String isbn) {
>>>>>>> Stashed changes
        String accept = request.getHeader("Accept");
        Book book = bookService.findById(isbn);
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

    public ResponseEntity<Void> updateBook(@ApiParam(value = "Book object that needs to be added to the store" ,required=true )  @Valid @RequestBody Book body) {
        String accept = request.getHeader("Accept");
        Book book = bookService.findById(body.getIsbn());
        if (book == null) {
            System.out.println("book not found");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else bookService.updateBook(body);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> updateBookIsbn(@ApiParam(value = "Book object that needs to be added to the store", required = true)@PathVariable("bookId") String isbn, @Valid @RequestBody Book body) {
        String accept = request.getHeader("Accept");
        Book book = bookService.findById(isbn);
        if (book == null) {
            System.out.println("book not found");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else bookService.updateBook(body);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
