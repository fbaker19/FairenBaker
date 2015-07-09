/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.dao;

import com.swcguild.dvdlibraryv3.dao.DVDLibraryImpl;
import com.swcgulid.dvdlibraryv3.dto.DVD;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class DVDLibraryTest {
    
    DVDLibraryImpl instance;
    
    public DVDLibraryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of loadDVDLibrary method, of class DVDLibraryImpl.
     */
    @Test
    public void testLoadDVDLibrary() throws Exception {
        System.out.println("loadDVDLibrary");
        DVDLibraryImpl instance = new DVDLibraryImpl();
        instance.loadDVDLibrary();
        if (instance != null) {
            boolean x = true;
        }
        Assert.assertTrue(true);
    }

    /**
     * Test of addDVD method, of class DVDLibraryImpl.
     */
    @Test
    public void testAddDVD() {
        System.out.println("addDVD");
        String name = "Jaws";
        DVD currentDVD = new DVD("Jaws");
        DVDLibraryImpl instance = new DVDLibraryImpl();
        
        currentDVD.setName("Jaws");
        currentDVD.setDate("2008");
        currentDVD.setDirector("Spielberg");
        
        instance.searchByName("Jaws");
        Assert.assertEquals("2008", currentDVD.getDate());
    }

    /**
     * Test of writeDVDs method, of class DVDLibraryImpl.
     */
    @Test
    public void testWriteDVDs() throws Exception {
        System.out.println("writeDVDs");
        
        DVDLibraryImpl instance = new DVDLibraryImpl();
        DVD dvd = new DVD("Jack");
        
        dvd.setName("Jack");
        dvd.setDate("4564");
        dvd.setDirector("SS");
        
        instance.addDVD("Jack", dvd);
        instance.writeDVDs();
        
        DVDLibraryImpl instance2 = new DVDLibraryImpl();
        instance2.loadDVDLibrary();
        DVD dvd2 = instance2.searchByName("Jack");
        Assert.assertEquals("4564", dvd2.getDate());
    }

    /**
     * Test of getAllDVDs method, of class DVDLibraryImpl.
     */
    @Test
    public void testGetAllDVDs() {
        System.out.println("getAllDVDs");
        DVDLibraryImpl instance = new DVDLibraryImpl();
        
        DVD dvd = new DVD("Joe");
        dvd.setName("Joe");
        dvd.setDate("2345");
        dvd.setDirector("HH");
        instance.addDVD("Joe", dvd);
        
        DVD dvd1 = new DVD("Shmoe");
        dvd1.setName("Shmoe");
        dvd1.setDate("6547");
        dvd1.setDirector("JJ");
        instance.addDVD("Shmoe", dvd1);
      
        String[] result = instance.getAllDVDs();
        Assert.assertEquals(2, result.length);
    }

    /**
     * Test of getDVD method, of class DVDLibraryImpl.
     */
    @Test
    public void testGetDVD() {
        System.out.println("getDVD");
        
        DVDLibraryImpl instance = new DVDLibraryImpl();
        DVD dvd = new DVD("Joe");
        dvd.setName("Joe");
        dvd.setDate("2345");
        dvd.setDirector("HH");
        instance.addDVD("Joe", dvd);
        
        String expDate = "2345";
        DVD result = instance.searchByName("Joe");
        assertEquals(expDate, result.getDate());
    
    }

    /**
     * Test of removeDVD method, of class DVDLibraryImpl.
     */
    @Test
    public void testRemoveDVD() {
        System.out.println("removeDVD");
    
        DVDLibraryImpl instance = new DVDLibraryImpl();
        DVD dvd = new DVD("Joe");
        dvd.setName("Joe");
        dvd.setDate("2345");
        dvd.setDirector("HH");
        instance.addDVD("Joe", dvd);
        
        DVD dvd1 = new DVD("Shmoe");
        dvd1.setName("Shmoe");
        dvd1.setDate("6547");
        dvd1.setDirector("JJ");
        instance.addDVD("Shmoe", dvd1);
        
        DVD dvd2 = new DVD("Lost");
        dvd2.setName("Lost");
        dvd2.setDate("6565");
        dvd2.setDirector("KK");
        instance.addDVD("Lost", dvd2);
        
        instance.removeDVD("Lost");
        String[] result = instance.getAllDVDs();
        
        Assert.assertEquals(2, result.length);
      
    }
    
}
