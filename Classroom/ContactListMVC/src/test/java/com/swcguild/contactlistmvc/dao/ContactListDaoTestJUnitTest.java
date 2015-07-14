/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.Contact;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class ContactListDaoTestJUnitTest {
    
    private ContactListDAO dao;//imports class
    
    public ContactListDaoTestJUnitTest() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        
        dao = ctx.getBean("contactListDao", ContactListDAO.class);//sets class to bean/Dependency Injection
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeleteCOnctact()
    {
        Contact nc = new Contact();
        nc.setFirstName("John");
        nc.setLastName("Doe");
        nc.setCompany("Oracle");
        nc.setEmail("jdoe@email.com");
        nc.setPhone("330-555-5489");
        
        dao.addContact(nc);
        
        Contact fromDb = dao.getContactById(nc.getContactId());
        assertEquals(fromDb, nc);
        
        dao.removeContact(nc.getContactId());
        assertNull(dao.getContactById(nc.getContactId()));
    }
    
    @Test
    public void addUpdateContacts()
    {
        Contact nc = new Contact();
        nc.setFirstName("Jimmy");
        nc.setLastName("smith");
        nc.setCompany("sun");
        nc.setEmail("jsmith@email.com");
        nc.setPhone("330-555-1111");
        
        dao.addContact(nc);
        
       nc.setPhone("9999999999");
       
       dao.updateContact(nc);
       
       Contact fromDb = dao.getContactById(nc.getContactId());
       assertEquals(fromDb, nc);
        
        
    }
    
    
    @Test
    public void getAllContacts()
    {
        Contact nc = new Contact();
        nc.setFirstName("Jimmy");
        nc.setLastName("smith");
        nc.setCompany("sun");
        nc.setEmail("jsmith@email.com");
        nc.setPhone("330-555-1111");
        
        dao.addContact(nc);
        
        Contact nc2 = new Contact();
        nc2.setFirstName("bobby");
        nc2.setLastName("jons");
        nc2.setCompany("MoonLabs");
        nc2.setEmail("bjons@email.com");
        nc2.setPhone("330-555-5555");
        
        dao.addContact(nc);
        
        Contact nc3 = new Contact();
        nc3.setFirstName("Ricky");
        nc3.setLastName("Right");
        nc3.setCompany("Maple");
        nc3.setEmail("RRight@email.com");
        nc3.setPhone("330-555-2341");
        
        dao.addContact(nc);
        
        
        List<Contact> cList = dao.getAllContacts();
        assertEquals(3, cList.size());
     
        
    }
    
}
