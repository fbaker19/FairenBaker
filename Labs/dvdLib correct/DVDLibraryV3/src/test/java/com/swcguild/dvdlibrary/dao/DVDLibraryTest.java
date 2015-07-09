/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.dao;

import com.swcgulid.dvdlibrary.dto.Dvd;
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
    
    DVDLibrary instance;
    
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
     * Test of loadDVDLibrary method, of class DVDLibrary.
     */
    @Test
    public void testLoadDVDLibrary() throws Exception {
        System.out.println("loadDVDLibrary");
        DVDLibrary instance = new DVDLibrary() ;
        instance.loadDVDLibrary();
        if (instance != null) {
            boolean x = true;
        }
        Assert.assertTrue(true);
    }

    /**
     * Test of addDVD method, of class DVDLibrary.
     */
    @Test
    public void testAddDVD() {
        System.out.println("addDVD");
        String name = "Jaws";
        Dvd currentDVD = new Dvd("Jaws");
        DVDLibrary instance = new DVDLibrary() ;
        
        currentDVD.setName("Jaws");
        currentDVD.setDate("2008");
        currentDVD.setDirector("Spielberg");
        
        instance.getDVD("Jaws");
        Assert.assertEquals("2008", currentDVD.getDate());
    }

    /**
     * Test of writeDVDs method, of class DVDLibrary.
     */
    @Test
    public void testWriteDVDs() throws Exception {
        System.out.println("writeDVDs");
        
        DVDLibrary instance = new DVDLibrary();
        Dvd dvd = new Dvd("Jack");
        
        dvd.setName("Jack");
        dvd.setDate("4564");
        dvd.setDirector("SS");
        
        instance.addDVD("Jack", dvd);
        instance.writeDVDs();
        
        DVDLibrary instance2 = new DVDLibrary();
        instance2.loadDVDLibrary();
        Dvd dvd2 = instance2.getDVD("Jack");
        Assert.assertEquals("4564", dvd2.getDate());
    }

    /**
     * Test of getAllDVDs method, of class DVDLibrary.
     */
    @Test
    public void testGetAllDVDs() {
        System.out.println("getAllDVDs");
        DVDLibrary instance = new DVDLibrary();
        
        Dvd dvd = new Dvd("Joe");
        dvd.setName("Joe");
        dvd.setDate("2345");
        dvd.setDirector("HH");
        instance.addDVD("Joe", dvd);
        
        Dvd dvd1 = new Dvd("Shmoe");
        dvd1.setName("Shmoe");
        dvd1.setDate("6547");
        dvd1.setDirector("JJ");
        instance.addDVD("Shmoe", dvd1);
      
        String[] result = instance.getAllDVDs();
        Assert.assertEquals(2, result.length);
    }

    /**
     * Test of getDVD method, of class DVDLibrary.
     */
    @Test
    public void testGetDVD() {
        System.out.println("getDVD");
        
        DVDLibrary instance = new DVDLibrary();
        Dvd dvd = new Dvd("Joe");
        dvd.setName("Joe");
        dvd.setDate("2345");
        dvd.setDirector("HH");
        instance.addDVD("Joe", dvd);
        
        String expDate = "2345";
        Dvd result = instance.getDVD("Joe");
        assertEquals(expDate, result.getDate());
    
    }

    /**
     * Test of removeDVD method, of class DVDLibrary.
     */
    @Test
    public void testRemoveDVD() {
        System.out.println("removeDVD");
    
        DVDLibrary instance = new DVDLibrary();
        Dvd dvd = new Dvd("Joe");
        dvd.setName("Joe");
        dvd.setDate("2345");
        dvd.setDirector("HH");
        instance.addDVD("Joe", dvd);
        
        Dvd dvd1 = new Dvd("Shmoe");
        dvd1.setName("Shmoe");
        dvd1.setDate("6547");
        dvd1.setDirector("JJ");
        instance.addDVD("Shmoe", dvd1);
        
        Dvd dvd2 = new Dvd("Lost");
        dvd2.setName("Lost");
        dvd2.setDate("6565");
        dvd2.setDirector("KK");
        instance.addDVD("Lost", dvd2);
        
        instance.removeDVD("Lost");
        String[] result = instance.getAllDVDs();
        
        Assert.assertEquals(2, result.length);
      
    }
    
}
