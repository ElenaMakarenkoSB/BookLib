/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.7-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Book;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-07-04T12:30:58.278Z")

@Api(value = "book", description = "the book API")
public interface BookApi {

    @ApiOperation(value = "Add a new book to the library", nickname = "addBook", notes = "", authorizations = {
        @Authorization(value = "petstore_auth", scopes = {
            @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
            @AuthorizationScope(scope = "read:pets", description = "read your books")
            })
    }, tags={ "book", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/book",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addBook(@ApiParam(value = "Book object that needs to be added to the store" ,required=true )  @Valid @RequestBody Book body);


    @ApiOperation(value = "Deletes a book", nickname = "deleteBook", notes = "", authorizations = {
        @Authorization(value = "petstore_auth", scopes = {
            @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
            @AuthorizationScope(scope = "read:pets", description = "read your books")
            })
    }, tags={ "book", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Book not found") })
    @RequestMapping(value = "/book/{bookId}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteBook(@ApiParam(value = "Book id to delete",required=true) @PathVariable("bookId") Long bookId,@ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey);


    @ApiOperation(value = "Find book by ID", nickname = "getBookById", notes = "Returns a single book", response = Book.class, authorizations = {
        @Authorization(value = "api_key")
    }, tags={ "book", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Book.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Book not found") })
    @RequestMapping(value = "/book/{bookId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Book> getBookById(@ApiParam(value = "ID of book to return",required=true) @PathVariable("bookId") Long bookId);


    @ApiOperation(value = "Update an existing book description", nickname = "updateBook", notes = "", authorizations = {
        @Authorization(value = "petstore_auth", scopes = {
            @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
            @AuthorizationScope(scope = "read:pets", description = "read your books")
            })
    }, tags={ "book", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Book not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/book",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateBook(@ApiParam(value = "Book object that needs to be added to the store" ,required=true )  @Valid @RequestBody Book body);

}
