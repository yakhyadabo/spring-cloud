package org.yakhya.spring.cloud.bookservice;


import io.swagger.annotations.ApiModelProperty;

public class Book {
  @ApiModelProperty(notes = "The database generated book ID")
  private Long id;

  @ApiModelProperty(notes = "The book author")
  private String author;

  @ApiModelProperty(notes = "The book title")
  private String title;

  public Book(Long id, String title, String author) {
    this.id = id;
    this.title = title;
    this.author = author;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  // standard getters and setters
}