/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.librarymvc.dao;

import com.swcguild.librarymvc.model.Author;
import com.swcguild.librarymvc.model.HBook;
import com.swcguild.librarymvc.model.Publisher;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
@Repository//"Hibernate, this is dao"( introduces directly to database)
@Transactional
public class LibraryDaoHibernateImpl implements HLibraryDao {

    private SessionFactory sessionFactory;

    @Inject
    public LibraryDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        Session session = null;
        try {
           session = this.sessionFactory.getCurrentSession();
        } catch (Exception e) {

        }
        if(session ==null)
        {
        session = this.sessionFactory.openSession();
        }
        return session;
    }

  //AUTHOR AUTHOR AUTHOR AUTHOR AUTHOR AUTHOR  AUTHOR AUTHOR AUTHOR  AUTHOR AUTHOR AUTHOR  
    //OPTIONAL(for Author) BUT REASON IS UNKNOWN: @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addAuthor(Author author) {
        currentSession().save(author);//adds author to the Database by finding "Author's" Table
    }//hibernate pulls info from author dto and injects it to the table specified on DTO ex @Table(name = "author")

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteAuthor(Author author) {
        currentSession().delete(author);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateAuthor(Author author) {
        currentSession().update(author);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Author getAuthorById(int authorId) {
        return (Author) currentSession().get(Author.class, authorId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Author> getAllAuthors() {
        return (List<Author>) currentSession().createCriteria(Author.class).list();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addBook(HBook book) {
        currentSession().save(book);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deletBook(HBook book) {
        currentSession().delete(book);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateBook(HBook book) {
        currentSession().update(book);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public HBook getBookById(int bookId) {
        return (HBook) currentSession().get(HBook.class, bookId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<HBook> getAllBooks() {
        return (List<HBook>) currentSession().createCriteria(HBook.class).list();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addPublisher(Publisher publisher) {
        currentSession().save(publisher);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deletePublisher(Publisher publisher) {
        currentSession().delete(publisher);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updatePublisher(Publisher publisher) {
        currentSession().update(publisher);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Publisher getPublisherById(int publisherId) {
        return (Publisher) currentSession().get(Publisher.class, publisherId);
    }//get class and eveything it encompasses as well as Id?

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Publisher> getAllPublishers() {
        return (List<Publisher>) currentSession().createCriteria(Publisher.class).list();
    }//get class and all that it encompasses and return it as  a list?

    
}
