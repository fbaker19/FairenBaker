/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook.dao;

import com.swcguild.addressbook.dto.Address;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class AddressBookTest {

    AddressBook ab;

    public AddressBookTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ab = new AddressBook();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of loadAddressBook method, of class AddressBook.
     */
    @Test
    public void testLoadAddressBook() throws Exception {
        System.out.println("loadAddressBook");
        AddressBook instance = new AddressBook();
        instance.loadAddressBook();
        //more than 1 entry;
        // Assert.assertEquals(instance, adbook.txt);
    }

    /**
     * Test of addAddress method, of class AddressBook.
     */
    @Test
    public void testAddAddress() {
        System.out.println("addAddress");
        String lastName = "Smith";
        Address address = new Address("Smith");
        AddressBook instance = new AddressBook();
        instance.addAddress(lastName, address);

        address.setCity("Detroit");
        address.setFirstName("Michael");
        address.setLastName("Smith");

        instance.addAddress("Smith", address);
        instance.getAddress("Smith");
        Assert.assertEquals("Detroit", address.getCity());
        //fail("The test case is a prototype.");
    }

    /**
     * Test of writeAddress method, of class AddressBook.
     */
    @Test
    public void testWriteAddress() throws IOException {
        System.out.println("writeAddress");

        AddressBook instance = new AddressBook();
        Address address = new Address("Smith");

        address.setCity("Detroit");
        address.setFirstName("Michael");
        address.setLastName("Smith");

        instance.addAddress("Smith", address);
        instance.writeAddress();
        // test if in the file adBook.txt
//no need for lines below this comment
        AddressBook instance2 = new AddressBook();
        instance2.loadAddressBook();
        Address address2 = instance2.getAddress("Smith");

        Assert.assertEquals("Detroit", address2.getCity());
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class AddressBook.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        String lastName = "Gleen";
        AddressBook instance = new AddressBook();
        Address expResult = null;
        Address result = instance.getAddress(lastName);
        Assert.assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAddresses method, of class AddressBook.
     */
    @Test
    public void testGetAllAddresses() {
        System.out.println("getAllAddresses");
        AddressBook instance = new AddressBook();
        Address address = new Address("Smith");
        address.setNumberAndStreet("123 Street St.");
        address.setCity("Akron");
        address.setState("OH");
        address.setLastName("Smith");
        instance.addAddress("Smith", address);
        Address address1 = new Address("Smith");
        address.setNumberAndStreet("432 Street St.");
        address.setCity("Dayton");
        address.setState("OH");
        address.setLastName("Jones");
        instance.addAddress("Jones", address);
        String[] result = instance.getAllAddresses();
        Assert.assertEquals(2, result.length);
    }

    /**
     * Test of removeAddress method, of class AddressBook.
     */
    @Test
    public void testRemoveAddress() {
        System.out.println("removeAddress");
        //String lastName = "Gleen";
        AddressBook instance = new AddressBook();
        Address address = new Address("Gleen");// TESTER
        address.setNumberAndStreet("123 Railway St.");
        address.setCity("San Francisco");
        address.setState("CA");
        address.setLastName("Gleen");
        instance.addAddress("Gleen", address);

        AddressBook instance2 = new AddressBook();
        Address address2 = new Address("Klim");// TESTER
        address.setNumberAndStreet("1523 Street rd.");
        address.setCity("Fresno");
        address.setState("CA");
        address.setLastName("Klim");
        instance.addAddress("Klim", address);

        String[] result = instance.getAllAddresses();
        instance.removeAddress("Gleen");

        Address expResult = null;

        Assert.assertEquals(2, result.length);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of totalNumber method, of class AddressBook.
     */
    @Test
    public void testTotalNumber() {
        System.out.println("totalNumber");
        AddressBook instance = new AddressBook();
        
        Address address = new Address("Gleen");// TESTER
        address.setNumberAndStreet("123 Railway St.");
        address.setCity("San Francisco");
        address.setState("CA");
        address.setLastName("Gleen");;
        
        instance.addAddress("Gleen", address);
        
        Address address1 = new Address("Michael");
        address.setNumberAndStreet("27102 Arlington Dr.");
        address.setCity("Gary");
        address.setState("IN");
        address.setLastName("Michael");
        
        instance.addAddress("Michael", address);
        
        Address address2 = new Address("Klim");
        address.setNumberAndStreet("1523 Street rd.");
        address.setCity("Fresno");
        address.setState("CA");
        address.setLastName("Klim");
        
        instance.addAddress("Klim", address);
        
        String result = instance.totalNumber();
        assertEquals("3", result);
    }
}


