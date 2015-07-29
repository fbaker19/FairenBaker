/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryweb;

import com.swcguild.dvdlibraryweb.dao.DVDLibraryImpl;
import com.swcguild.dvdlibraryweb.model.DVD;
import com.swcguild.dvdlibraryweb.model.DvdSearchTerms;
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
public class DvdLibraryMVCtest {
    DVDLibraryImpl dao;
    public DvdLibraryMVCtest() {
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
        dao = ctx.getBean("dvdLibraryDao", com.swcguild.dvdlibraryweb.dao.DVDLibraryImpl.class);
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
    public void deleteDvd() {
        
        DVD dvd = new DVD();
        //SET
        dvd.setTitle("Pulp Fiction");
        dvd.setReleaseDate("05/02/1994");
        dvd.setMpaa("R");
        dvd.setRating("8.7");
        dvd.setDirector("Quentin Tarantino");
        dvd.setStudio("Miramax");
        

        dao.addDvd(dvd);
        DVD result = dao.getTitle(dvd.getId());
        
        assertEquals(dvd, result);
        dao.removeTitle(dvd.getId());
        
        assertNull(dao.getTitle(dvd.getId()));

    }

    @Test
    public void updateDvd()  {

        DVD dvd = new DVD();
        
        dvd.setTitle("Star Wars: The Force Awakens");
        dvd.setReleaseDate("12/25/2015");
        dvd.setMpaa("PG13");
        dvd.setDirector("JJ Abrams");
        dvd.setStudio("Lucus-Films");
        dvd.setRating("8.2");
        
        dao.addDvd(dvd);
        
        
        dvd.setStudio("Disney Studios");
        
        dao.updateLibrary(dvd);
        DVD result = dao.getTitle(dvd.getId());
        assertEquals(dvd, result);
    }

    @Test
    public void getAllDvds(){

        DVD dvd = new DVD();
        
        dvd.setTitle("Pinapple Express");
        dvd.setReleaseDate("8/6/2008");
        dvd.setMpaa("R");
        dvd.setRating("7.7");
        dvd.setDirector(" David Gordon Green");
        dvd.setStudio("Columbia Pictures");

        dao.addDvd(dvd);

        DVD dvd2 = new DVD();
        
        dvd2.setTitle("Death Proof");
        dvd2.setReleaseDate("9/18/2007");
        dvd2.setMpaa("R");
        dvd2.setDirector("Quentin Tarantino");
        dvd2.setStudio("Dimension Films");
        dvd2.setRating("8.5");

        dao.addDvd(dvd2);

        List<DVD> dList = dao.getAllTitles();
        
        assertEquals(2, dList.size());
        
        assertEquals(dvd, dao.getTitle(dvd.getId()));
        assertEquals(dvd2, dao.getTitle(dvd2.getId()));
    }
    
       @Test
    public void searchDvds()  {
        DVD dvd = new DVD();
        
        dvd.setTitle("Pinapple Express");
        dvd.setReleaseDate("8/6/2008");
        dvd.setMpaa("R");
        dvd.setRating("7.7");
        dvd.setDirector(" David Gordon Green");
        dvd.setStudio("Columbia Pictures");

        dao.addDvd(dvd);

        DVD dvd2 = new DVD();
        dvd2.setTitle("Death Proof");
        dvd2.setReleaseDate("9/18/2007");
        dvd2.setMpaa("R");
        dvd2.setDirector("Quentin Tarantino");
        dvd2.setStudio("Dimension Films");
        dvd2.setRating("8.5");

        dao.addDvd(dvd2);

        DVD dvd3 = new DVD();
        
        dvd3.setTitle("Star Wars: The Force Awakens");
        dvd3.setReleaseDate("12/25/2015");
        dvd3.setMpaa("PG13");
        dvd3.setDirector("JJ Abrams");
        dvd3.setStudio("Lucus-Films");
        dvd3.setRating("8.2");

        dao.addDvd(dvd3);
  
        Map<DvdSearchTerms,String> criteria = new HashMap<>();
        
        criteria.put(DvdSearchTerms.TITLE, "Death Proof");
        List<DVD> dList = dao.searchDvd(criteria);
        
        assertEquals(1, dList.size());
        assertEquals(dvd2, dList.get(0));
        
        criteria = new HashMap<>();
        criteria.put(DvdSearchTerms.TITLE, "Star Wars: The Force Awakens");
        dList = dao.searchDvd(criteria);
        
        assertEquals(1, dList.size());
       
        assertTrue(dList.contains(dvd3));
          
          
        criteria = new HashMap<>();
       //???????????????????????????????
        criteria.put(DvdSearchTerms.MPAA, "R");
        dList = dao.searchDvd(criteria);
       
        assertEquals(2, dList.size());
         assertTrue(dList.contains(dvd));
        assertTrue(dList.contains(dvd2));
        
        criteria = new HashMap<>();
        criteria.put(DvdSearchTerms.MPAA, "PG13");
        dList = dao.searchDvd(criteria);
        assertEquals(1, dList.size());
        
        criteria = new HashMap<>();
        criteria.put(DvdSearchTerms.MPAA, "G");
        dList = dao.searchDvd(criteria);
        assertEquals(0, dList.size());
          
    }
}
