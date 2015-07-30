/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.librarymvc.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * HIBERNATE LECTURE HIBERNATE LECTURE HIBERNATE LECTURE HIBERNATE LECTURE
 * HIBERNATE LECTURE HIBERNATE LECTURE HIBERNATE LECTURE HIBERNATE LECTURE
 * HIBERNATE LECTURE HIBERNATE LECTURE HIBERNATE LECTURE HIBERNATE LECTURE
 *
 * @author apprentice
 */
@Entity//marks class as an entity for Hibernate Frame work(Hibernate Controller)
@Table(name = "books")//marks the class as it relates to the 'book' table in database

public class HBook {

    @Id//marks primary key field
    @GeneratedValue//auto-increment in database
    @Column(name = "bookId")
    private int bookId;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title")
    private String title;

    @ManyToOne//many books to 1 publishers
    @JoinColumn(name = "publisher_id")
    private Publisher publisher; //"Publisher" brings over whole publisher Dto

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})//fetches all the authors per book requested
    @JoinTable(name = "books_authors",
          joinColumns = { @JoinColumn(name = "book_id")},
          inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authors;
   
    @Column(name = "price")
    private BigDecimal price;
    
    @Column(name="publish_date")//java.util.date(NOT SQL DATE, will  not work!!!)
    private Date publishDate;

    
    
    
    
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

}
