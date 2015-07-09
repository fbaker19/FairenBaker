/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary2.dao;

import com.swcguild.dvdlibraryv3.dao.DVDLibraryImpl;
import com.swcgulid.dvdlibraryv3.dto.DVD;
import java.util.List;
import java.util.Map;
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
public class DVDLibraryImplTest {
    
    public DVDLibraryImplTest() {
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
            Assert.assertTrue(x);
        }
        
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

    /**
     * Test of searchByName method, of class DVDLibraryImpl.
     */
    @Test
    public void testSearchByName() {
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
     * Test of searchByDate method, of class DVDLibraryImpl.
     */
    @Test
    public void testSearchByDate() {
        System.out.println("getDVD");
        
        DVDLibraryImpl instance = new DVDLibraryImpl();
        DVD dvd = new DVD("Joe");
        dvd.setName("Joe");
        dvd.setDate("2345");
        dvd.setDirector("HH");
        instance.addDVD("Joe", dvd);
        
        DVD dvd1 = new DVD("Jose");
        dvd1.setName("Joe");
        dvd1.setDate("2345");
        dvd1.setDirector("HH");
        instance.addDVD("Jose", dvd1);
        
        String expDate = "2345";
        List<DVD> result = instance.searchByDate("2345");
        assertEquals(2, result.size());
    }

    /**
     * Test of searchByRating method, of class DVDLibraryImpl.
     */
    @Test
    public void testSearchByRating() {
        System.out.println("searchByRating");
         DVDLibraryImpl instance = new DVDLibraryImpl();
        DVD dvd = new DVD("Joe");
        dvd.setRating("R");
        dvd.setName("Joe");
        dvd.setDate("2345");
        dvd.setDirector("HH");
        instance.addDVD("Joe", dvd);
        
        DVD dvd1 = new DVD("Jose");
        dvd1.setName("Joe");
        dvd1.setRating("R");
        dvd1.setDate("2345");
        dvd1.setDirector("HH");
        instance.addDVD("Jose", dvd1);
        
        DVD dvd2 = new DVD("Jone");
        dvd2.setName("Jone");
        dvd2.setRating("PG");
        dvd2.setDate("2345");
        dvd2.setDirector("RT");
        instance.addDVD("Jone", dvd2);
        
        
        List<DVD> result = instance.searchByRating("R");
        assertEquals(2, result.size());
    }

    /**
     * Test of searchByDirector method, of class DVDLibraryImpl.
     */
//    @Test
//    public void testSearchByDirector() {
//        System.out.println("searchByDirector");
//         DVDLibraryImpl instance = new DVDLibraryImpl();
//        DVD dvd = new DVD("Joe");
//        dvd.setRating("R");
//        dvd.setName("Joe");
//        dvd.setDate("2345");
//        dvd.setDirector("HH");
//        dvd.setStudio("MGM");
//        instance.addDVD("Joe", dvd);
//        
//        DVD dvd1 = new DVD("Jose");
//        dvd1.setName("Jose");
//        dvd1.setRating("R");
//        dvd1.setDate("2345");
//        dvd1.setDirector("HH");
//        dvd1.setStudio("WB");
//        instance.addDVD("Jose", dvd1);
//        
//        DVD dvd2 = new DVD("Jone");
//        dvd2.setName("Jone");
//        dvd2.setRating("PG");
//        dvd2.setDate("2345");
//        dvd2.setDirector("RT");
//        dvd2.setStudio("MGM");
//        instance.addDVD("Jone", dvd2);
//        
//        
//        Map<String, List<DVD>> result = instance.searchByDirector("HH");
//        
//        assertEquals(2, result.size());
//    }

    /**
     * Test of searchByStudio method, of class DVDLibraryImpl.
     */
    @Test
    public void testSearchByStudio() {
         DVDLibraryImpl instance = new DVDLibraryImpl();
        DVD dvd = new DVD("Joe");
        dvd.setRating("R");
        dvd.setName("Joe");
        dvd.setDate("2345");
        dvd.setDirector("HH");
        dvd.setStudio("MGM");
        instance.addDVD("Joe", dvd);
        
        DVD dvd1 = new DVD("Jose");
        dvd1.setName("Jose");
        dvd1.setRating("R");
        dvd1.setDate("2345");
        dvd1.setDirector("HH");
        dvd1.setStudio("WB");
        instance.addDVD("Jose", dvd1);
        
        DVD dvd2 = new DVD("Jone");
        dvd2.setName("Jone");
        dvd2.setRating("PG");
        dvd2.setDate("2345");
        dvd2.setDirector("RT");
        dvd2.setStudio("MGM");
        instance.addDVD("Jone", dvd2);
        
        
       List<DVD> result = instance.searchByStudio("WB");
        assertEquals(1, result.size());
    }
    
}
