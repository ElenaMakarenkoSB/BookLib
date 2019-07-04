package io.swagger.api;

import io.swagger.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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

    public ResponseEntity<Void> addBook(@ApiParam(value = "Book object that needs to be added to the store" ,required=true )  @Valid @RequestBody Book body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteBook(@ApiParam(value = "Book id to delete",required=true) @PathVariable("bookId") Long bookId,@ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Book> getBookById(@ApiParam(value = "ID of book to return",required=true) @PathVariable("bookId") Long bookId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Book>(objectMapper.readValue("{  \"releaseDate\" : \"1st August 1996\",  \"author\" : \"George R. R. Martin\",  \"isbn\" : 0,  \"publisher\" : \"Simon & Schuster\",  \"title\" : \"A Game Of Thrones\",  \"status\" : \"available\"}", Book.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Book>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Book>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateBook(@ApiParam(value = "Book object that needs to be added to the store" ,required=true )  @Valid @RequestBody Book body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
