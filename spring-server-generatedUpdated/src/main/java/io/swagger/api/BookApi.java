/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.7-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Book;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-04T12:30:58.278Z")

@Api(value = "book", description = "the book API")
public interface BookApi {

    @ApiOperation(value = "Find all Book", nickname = "getBooks", notes = "Returns Books", response = Book.class, authorizations = {
            @Authorization(value = "api_key")
    }, tags = {"bookLib",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Book.class)})
    @RequestMapping(value = "/getBooks",
            method = RequestMethod.GET)
    ResponseEntity<List<Book>> getBooks();

    @ApiOperation(value = "Add a new book to the library", nickname = "addBook", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
                    @AuthorizationScope(scope = "read:pets", description = "read your books")
            })
    }, tags = {"book",})
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input")})
    @RequestMapping(value = "/addBook",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> addBook(@ApiParam(value = "Book object that needs to be added to the store", required = true) @Valid @RequestBody Book body);


    @ApiOperation(value = "Deletes a book", nickname = "deleteBook", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
                    @AuthorizationScope(scope = "read:pets", description = "read your books")
            })
    }, tags = {"book",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Book not found")})
    @RequestMapping(value = "/deleteBook/{bookId}",
            produces = {"application/json", "application/xml"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteBook(@ApiParam(value = "Book id to delete", required = true) @PathVariable("bookId") String isbn, @ApiParam(value = "") @RequestHeader(value = "api_key", required = false) String apiKey);


    @ApiOperation(value = "Find book by ID", nickname = "getBookById", notes = "Returns a single book", response = Book.class, authorizations = {
            @Authorization(value = "api_key")
    }, tags = {"book",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Book.class),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Book not found")})
    @RequestMapping(value = "/getBook/{bookId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Book> getBookById(@ApiParam(value = "ID of book to return", required = true) @PathVariable("bookId") String isbn);


    @ApiOperation(value = "Update an existing book description", nickname = "updateBook", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
                    @AuthorizationScope(scope = "read:pets", description = "read your books")
            })
    }, tags = {"book",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Book not found"),
            @ApiResponse(code = 405, message = "Validation exception")})
    @RequestMapping(value = "/updateBook",
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"},
            method = RequestMethod.PUT)
    ResponseEntity<Book> updateBook(@ApiParam(value = "Book object that needs to be added to the store", required = true) @Valid @RequestBody Book body);


    @ApiOperation(value = "Update an existing book description", nickname = "updateBook", notes = "", authorizations = {
            @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
                    @AuthorizationScope(scope = "read:pets", description = "read your books")
            })
    }, tags = {"book",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Book not found"),
            @ApiResponse(code = 405, message = "Validation exception")})
    @RequestMapping(value = "/{bookId}",
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"},
            method = RequestMethod.PATCH)
    ResponseEntity<Book> updatePartially(@ApiParam(value = "Book object that needs to be added to the store", required = true) @PathVariable("bookId") String id, @Valid @RequestBody Book body);

}
