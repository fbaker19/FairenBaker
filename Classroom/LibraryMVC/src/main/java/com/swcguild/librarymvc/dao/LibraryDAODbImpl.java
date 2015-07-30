/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.librarymvc.dao;

import com.swcguild.librarymvc.model.Author;
import com.swcguild.librarymvc.model.Book;
import com.swcguild.librarymvc.model.Publisher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class LibraryDAODbImpl implements LibraryDao {

    private JdbcTemplate jdbcTemplate;

    //injects the method
    private void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
//FINAL STRING NAMES === CAPITALILZED
    //AUTHORS AUTHORS AUTHORS AUTHORS  AUTHORS  AUTHORS  AUTHORS  AUTHORS  AUTHORS  AUTHORS  AUTHORS  AUTHORS  AUTHORS  AUTHORS  
    private static final String SQL_INSERT_AUTHOR = "INSERT INTO authors (first_name, last_name, street, state, zip, phone) VALUES( ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_AUTHOR = "DELETE FROM authors WHERE author_id =?";

    private static final String SQL_UPDATE_AUTHOR = "UPDATE authors SET first_name = ?, last_name = ?, street = ?, state = ?, zip = ?, phone = ? WHERE author_id";

    private static final String SQL_SELECT_AUTHOR = "SELECT * FROM authors WHERE author_id = ?";
    //au./ba. are aliases
    private static final String SQL_SELECT_AUTHORS_BY_BOOK_ID = "SELECT au.author_id, au.first_name, au.last_name, au.street, au.state, au.zip, au.phone FROM authors au "
            + "JOIN books_authors ba on au.author_id = ba.author_id WHERE ba.book_id =  ?";
    private static final String SQL_SELECT_ALL_AUTHORS = "SELECT * FROM  authors";

    //BOOKS AND BOOK_AUTHORS/ BOOKS AND BOOK_AUTHORS/ BOOKS AND BOOK_AUTHORS /BOOKS AND BOOK_AUTHORS /BOOKS AND BOOK_AUTHORS / BOOKS AND BOOK_AUTHORS
    private static final String SQL_INSERT_BOOK = "INSERT INTO books (isbn, title, publisher_id, price, publish_date) VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_INSERT_BOOKS_AUTHORS = "INSERT INTO books_authors (book_id, author_id) VALUES(?,?) ";

    private static final String SQL_DELETE_BOOK = "DELETE FROM books WHERE book_id=?";

    private static final String SQL_DELETE_BOOKS_AUTHORS = "DELETE FROM books-authors WHERE book_id = ?";

    private static final String SQL_UPDATE_BOOK = "UPDATE books SET isbn =?, title=?, publisher_id = ?, price = ?, publish_date = ? WHERE book_id=?";

    private static final String SQL_SELECT_BOOK = "SELECT * FROM books WHERE book_id = ?";

    private static final String SQL_SELECT_BOOKS_AUTHORS_AUTHOR_ID_BY_BOOK_ID = "SELECT author_id FROM books_authors WHERE book_id = ?";

    private static final String SQL_SELECT_ALL_BOOKS = "SELECT * FROM books";

    private static final String SQL_SELECT_BOOKS_BY_AUTHOR_ID = "SELECT b.book_id, b.isbn, b.title, b.publisher_id, b.price, b.publish_date FROM books b "
            + "JOIN books_authors ba on ba.book_id = b.book_id WHERE ba.author_id = ?";
    private static final String SQL_SELECT_BOOKS_BY_PUBLISHER_ID = "SELECT * FROM books WHERE publiser_id = ?";

    //PUBLISHER PUBLISHER PUBLISHER PUBLISHER PUBLISHER PUBLISHER PUBLISHER PUBLISHER PUBLISHER   PUBLISHER PUBLISHER PUBLISHER 
    private static final String SQL_INSERT_PUBLISHER = "INSERT INTO publishers (name, street, city, state, zip, phone) VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_PUBLISHER = "DELETE FROM publishers WHERE publisher_id =?";

    private static final String SQL_UPDATE_PUBLISHER = "UPDATE publisherrs SET name = ?, street =?, city = ?, state =?, zip =?, phone =? WHERE publisher_id =?";

    private static final String SQL_SELECT_PUBLISHER = "SELECT * FROM publishers WHERE publisher_id =?";

    private static final String SQL_SELECT_PUBLISHER_BY_BOOK_ID = "SELECT pub.publisher_id, pub.name, pub.street, pub.city, pub,state, pub.zip, pub.phone FROM publishers pub "
            + "JOIN books on ppub.publisherr_id = books.publisher_id  WHERE books.book_id=?";
    private static final String SQL_SELECT_ALL_PUBLISHERS = "SELECT * FROM publishers";

    //AUTHOR METHODS   AUTHOR METHODS  AUTHOR METHODS   AUTHOR METHODS   AUTHOR METHODS   AUTHOR METHODS 
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Author addAuthor(Author author) {
        jdbcTemplate.update(SQL_INSERT_AUTHOR,
                author.getFirstName(),
                author.getLastName(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getZip(),
                author.getPhone());
        author.setAuthorId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return author;
    }

    @Override
    public void deleteAuthor(int authorId) {
        jdbcTemplate.update(SQL_DELETE_AUTHOR, authorId);
    }

    @Override
    public void updateAuthor(Author author) {
        jdbcTemplate.update(SQL_UPDATE_AUTHOR,
                author.getFirstName(),
                author.getLastName(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getZip(),
                author.getAuthorId());
    }

    @Override
    public Author getAuthorById(int authorId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_AUTHOR, new AuthorMapper(), authorId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Author> getAuthorsByBookId(int bookId) {
        return jdbcTemplate.query(SQL_SELECT_AUTHORS_BY_BOOK_ID, new AuthorMapper(), bookId);
    }

    @Override
    public List<Author> getAllAuthors() {
        return jdbcTemplate.query(SQL_SELECT_ALL_AUTHORS, new AuthorMapper());
    }

    //PROPAGATION USED WHEN  TABLES ARE LINKED
    //BOOK METHODS  BOOK METHODS   BOOK METHODS   BOOK METHODS   BOOK METHODS   BOOK METHODS   BOOK METHODs   BOOK METHODs   BOOK METHODs  
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)//pulling from more thatn one db
    public Book addBook(Book book) {
        jdbcTemplate.update(SQL_INSERT_BOOK,
                book.getIsbn(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice(),
                book.getPublishDate().toString());

        book.setBookId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));

        return book;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteBook(int bookId) {
        jdbcTemplate.update(SQL_DELETE_BOOKS_AUTHORS, bookId);//first take out the author
        jdbcTemplate.update(SQL_DELETE_BOOK, bookId);//then remove the whole book
    }                                                   //this is due to propogation(will  not allow for deletion otherwise)

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateBook(Book book) {
        jdbcTemplate.update(SQL_UPDATE_BOOK,
                book.getIsbn(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice(),
                book.getPublishDate().toString(),
                book.getBookId());

        jdbcTemplate.update(SQL_DELETE_BOOKS_AUTHORS, book.getBookId());
        insertBooksAuthors(book);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Book getBookById(int bookId) {

        try {
            Book b = jdbcTemplate.queryForObject(SQL_SELECT_BOOK, new BookMapper(), bookId);

            int[] idArray = getAuthorIdsForBook(b);//requires an additional query

            b.setAuthorIds(idArray);
            return b;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public List<Book> getBooksByAuthorId(int authorId) {

        List<Book> bList = jdbcTemplate.query(SQL_SELECT_BOOKS_BY_AUTHOR_ID, new BookMapper(), authorId);

        for (Book b : bList)//dto(Book) forVar(b): listVar(bList)
        {
            b.setAuthorIds(getAuthorIdsForBook(b));
        }

        return bList;
    }

    //PUBLISHER METHODS/
    @Override
    public List<Book> getBooksByPublisherId(int publisherId) {

        List<Book> bList = jdbcTemplate.query(SQL_SELECT_BOOKS_BY_PUBLISHER_ID, new BookMapper(), publisherId);
        for (Book b : bList)//dto(Book) forVar(b): listVar(bList)
        {
            b.setAuthorIds(getAuthorIdsForBook(b));
        }

        return bList;
    }

    @Override
    public List<Book> getAllBooks() {

        List<Book> bList = jdbcTemplate.query(SQL_SELECT_ALL_BOOKS, new BookMapper());

        for (Book b : bList)//dto(Book) forVar(b): listVar(bList)
        {
            b.setAuthorIds(getAuthorIdsForBook(b));
        }

        return bList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Publisher addPublisher(Publisher publisher) {
        jdbcTemplate.update(SQL_INSERT_PUBLISHER,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getZip(),
                publisher.getPhone());
        publisher.setPublisherId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        return publisher;
    }

    @Override
    public void deletePublisher(int publisherId) {
        jdbcTemplate.update(SQL_DELETE_PUBLISHER, publisherId);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(SQL_UPDATE_PUBLISHER,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getZip(),
                publisher.getPhone(),
                publisher.getPublisherId());
    }

    @Override
    public Publisher getPublisherById(int publisherId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PUBLISHER, new PublisherMapper(), publisherId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public Publisher getPublisherByBookId(int bookId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PUBLISHER_BY_BOOK_ID, 
                    new PublisherMapper(), bookId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_PUBLISHERS, new PublisherMapper());
    }

//HELPER METHODS!!!!!!!!!!!!!!!!!!!
    private void insertBooksAuthors(Book book) {
        final int bookId = book.getBookId();
        final int[] authorIds = book.getAuthorIds();

        jdbcTemplate.batchUpdate(SQL_INSERT_BOOKS_AUTHORS, new BatchPreparedStatementSetter()//<---Import from SPRING
        {
            //BatchPreparedStatementSetter implements these 2 methods(setValues & batchSize)
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, bookId);
                ps.setInt(2, authorIds[i]);
            }

            @Override
            public int getBatchSize() {
                return authorIds.length;// returns the authors in the array
            }

        });

    }

    private int[] getAuthorIdsForBook(Book book) {

        List<Integer> authorIds = jdbcTemplate.queryForList(SQL_SELECT_BOOKS_AUTHORS_AUTHOR_ID_BY_BOOK_ID,
                new Integer[]{book.getBookId()}, Integer.class);

        int[] idArray = new int[authorIds.size()];
        for (int i = 0; i < authorIds.size(); i++) {
            idArray[i] = authorIds.get(i);
        }
        return idArray;
    }

    private static final class AuthorMapper implements ParameterizedRowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int i) throws SQLException {
            Author au = new Author();
            au.setFirstName(rs.getString("first_name"));
            au.setLastName(rs.getString("last_name"));
            au.setStreet(rs.getString("street"));
            au.setCity(rs.getString("city"));
            au.setState(rs.getString("state"));
            au.setZip(rs.getString("zip"));
            au.setPhone(rs.getString("phone"));
            au.setAuthorId(rs.getInt("author_id"));
            return au;
        }

    }

    private static final class BookMapper implements ParameterizedRowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {
            Book b = new Book();

            b.setBookId(rs.getInt("book_id"));
            b.setIsbn(rs.getString("isbn"));
            b.setTitle(rs.getString("title"));
            b.setPublisherId(rs.getInt("publisher_id"));
            b.setPrice(rs.getBigDecimal("price"));
            b.setPublishDate(rs.getTimestamp("publish_date").toLocalDateTime().toLocalDate());

            return b;

        }
    }
        private static final class PublisherMapper implements ParameterizedRowMapper <Publisher>
        {

            @Override
            public Publisher mapRow(ResultSet rs, int i) throws SQLException {
                  Publisher pb = new Publisher();
                  
                   pb.setPublisherId(rs.getInt("publisher_id"));
                   pb.setName(rs.getString("name"));
                   pb.setStreet(rs.getString("street"));
                   pb.setCity(rs.getString("city"));
                   pb.setState(rs.getString("state"));
                   pb.setZip(rs.getString("zip"));
                   pb.setPhone(rs.getString("phone"));
                   
                   return pb;
            }
 
        }

    }

