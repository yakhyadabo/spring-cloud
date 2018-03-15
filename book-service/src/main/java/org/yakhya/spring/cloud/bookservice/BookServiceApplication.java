package org.yakhya.spring.cloud.bookservice;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
@Api(value="onlinestore", description="Operations pertaining to books in Online Store")
@RequestMapping("/books")
public class BookServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(BookServiceApplication.class, args);
  }

  private List<Book> bookList = Arrays.asList(
      new Book(1L, "Baeldung goes to the market", "Tim Schimandle"),
      new Book(2L, "Baeldung goes to the park", "Slavisa")
  );


  @ApiOperation(value = "View a list of available books", response = Iterable.class)

  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
  )
  @GetMapping("")
  public List<Book> findAllBooks() {
    return bookList;
  }

  @ApiOperation(value = "Search a book with an ID",response = Book.class)
  @GetMapping("/{bookId}")
  public Book findBook(@PathVariable Long bookId) {
    return bookList.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);
  }
}