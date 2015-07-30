/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.librarymvc;

import com.swcguild.librarymvc.dao.HLibraryDao;
import com.swcguild.librarymvc.dao.LibraryDaoHibernateImpl;
import com.swcguild.librarymvc.model.Author;
import com.swcguild.librarymvc.model.HBook;
import com.swcguild.librarymvc.model.Publisher;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class LibraryDaoHibernateUnitTest {
    //SET UP in Global Scope
    //Dao
    private HLibraryDao dao; 
   //DTOs
    private HBook b1;
    private HBook b2;
    private HBook b3;
    
    private Author a1;
    private Publisher p1;
    
    public LibraryDaoHibernateUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");//saves to test file
        dao = ctx.getBean("hibernateLibraryDao", HLibraryDao.class);//imports <bean>
        //SET UP 
        
        p1 = new Publisher();
        p1.setCity("Cleveland");
        p1.setName("pigeon");
        p1.setStreet("123 Seaseme St");
        p1.setState("OH");
        p1.setZip("41141");
        p1.setPhone("5551212");
        
        b1 = new HBook();
        b1.setIsbn("ISBN-12345");
        b1.setPrice(new BigDecimal(123.45));
        b1.setPublishDate(new Date());
        b1.setTitle("Some Book");
        
        
    }
    
    
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
//    @Test
//    public void addGetRemoveBook()
//    {
//        dao.addBook(b1);//adds book
//        HBook result = dao.getBookById(b1.getBookId());//gets book by Id
//        
//        assertEquals(b1, result);//b1 is result
//    }
    @Test
    public void addGetRemovePublisher()
    {
        dao.addPublisher(p1);//adds book
        Publisher result = dao.getPublisherById(p1.getPublisherId());//gets book by Id
        //No DELETE method present
        assertEquals(p1, result);//p1 is result
    }
}
