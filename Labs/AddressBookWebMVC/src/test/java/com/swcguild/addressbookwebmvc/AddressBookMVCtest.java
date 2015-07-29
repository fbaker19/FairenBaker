/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookwebmvc;

import com.swcguild.addressbookwebmvc.dao.AddressBookImplDao;
import com.swcguild.addressbookwebmvc.model.Address;
import com.swcguild.addressbookwebmvc.model.AddressSearchTerm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class AddressBookMVCtest {
    AddressBookImplDao dao;
    
       Address add1 = new Address();
       Address add2 = new Address();
       Address add3 = new Address();
    
       public AddressBookMVCtest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
                ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("addressBookDao", AddressBookImplDao.class);
        
        add1.setFirstName("Bob");
        add1.setLastName("Ross");
        add1.setNumberAndStreet("123 Calm Bush Dr.");
        add1.setCity("Paintersville");
        add1.setState("Washington");
        add1.setZip("55212");
     
        
        add2.setFirstName("Martha ");
        add2.setLastName("Stewart");
        add2.setNumberAndStreet("256 Cupcake Ln.");
        add2.setCity("Bakerstown");
        add2.setState("New Hampshire");
        add2.setZip("49526");
        
        add3.setFirstName("Michael");
        add3.setLastName("Jordan");
        add3.setNumberAndStreet("777 B-Ball Ct.");
        add3.setCity("Chicago");
        add3.setState("Illinois");
        add3.setZip("63257");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void removeAddress() {
        //SET
        dao.addAddress(add1);
       
        Address result = dao.getAddressId(add1.getId());
        assertEquals(add1, result);
        dao.removeAddress(add1.getId());//(add1.getId());
        assertNull(dao.getAddressId(add1.getId()));
        
    }

    @Test
    public void updateAddress() {
         //SET
        dao.addAddress(add2);
        
        add2.setFirstName("Rick");
        dao.updateAddress(add2);
        Address result = dao.getAddressId(add2.getId());
        assertEquals(add2, result);
    }

    @Test
    public void getAllAddress() {
         //SET
        dao.addAddress(add3);
        dao.addAddress(add2);
        
        List<Address> address = dao.getAllAddresses();
        assertEquals(2, address.size());
        assertEquals(add3, dao.getAddressId(add3.getId()));
        assertEquals(add2, dao.getAddressId(add2.getId()));
    }
    
    public void searchAddresses(){
       //SET
        dao.addAddress(add1);
        dao.addAddress(add2);
        dao.addAddress(add3);
        
       
        
        Map<AddressSearchTerm, String> criteria = new HashMap<>();
       
        criteria.put(AddressSearchTerm.FIRST_NAME, "Bob");
        List<Address> aList = dao.searchAddress(criteria);
        assertEquals(1, aList.size());
        assertTrue(aList.contains(add1));
       
        criteria.clear();
        
        criteria.put(AddressSearchTerm.STATE, "Illinois");
        aList = dao.searchAddress(criteria);
        assertEquals(1, aList.size());
        assertTrue(aList.contains(add3));
        
        criteria.clear();
       
        criteria.put(AddressSearchTerm.ZIP, "49526");//what is entered
        aList = dao.searchAddress(criteria);// where/how to look
        assertEquals(0, aList.size());//what should be produced
    
    }
}
