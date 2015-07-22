/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.DVD;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class DvdLibraryV3TestFB {

    ApplicationContext ctx;

    DvdLibraryDao dao;

    /////global scope///////
    DVD dvd1 = new DVD();
    DVD dvd2 = new DVD();
    DVD dvd3 = new DVD();

    public DvdLibraryV3TestFB() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FileNotFoundException {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = ctx.getBean("dvdLibraryDao", DvdLibraryDao.class);

        
        ///TEST INFO/COMPARE ///
        dvd1.setId(1);
        dvd1.setTitle("The Avengers");
        dvd1.setReleaseDate(LocalDate.parse("2012-05-04"));
        dvd1.setMpaaRating("PG13");
        dvd1.setDirector("Joss Whedon");
        dvd1.setStudio("Marvel");
        dvd1.setNote("Hulk Smash!!!");

        dvd2.setId(2);
        dvd2.setTitle("Pulp Fiction");
        dvd2.setReleaseDate(LocalDate.parse("1994-06-28"));
        dvd2.setMpaaRating("R");
        dvd2.setDirector("Quentin Tarantino");
        dvd2.setStudio("Sony");
        dvd2.setNote("Say 'What' ONE.MORE.TIME");

        dvd3.setId(3);
        dvd3.setTitle("Star Wars: The Force Awakens");
        dvd3.setReleaseDate(LocalDate.parse("2015-12-25"));
        dvd3.setMpaaRating("PG13");
        dvd3.setDirector("JJ Abrams");
        dvd3.setStudio("Lucus-Films");
        dvd3.setNote("These are not the droids you are looking for");

    }

    @After
    public void tearDown() {
    }

//    DVD dvd1 = new DVD();
//    DVD dvd2 = new DVD();
//    DVD dvd3 = new DVD();
    @Test
    public void add() {
      
        dao.add(dvd1);
        dao.add(dvd2);

        DVD result = dao.getById(dvd1.getId());
        Assert.assertEquals(dvd1, result);

        DVD result2 = dao.getById(dvd2.getId());
        Assert.assertEquals(dvd2, result2);

    }

    @Test
    public void remove() {
       
        dao.add(dvd1);
        dao.add(dvd2);
        dao.add(dvd3);

        dao.remove(dvd1.getId());
        List<DVD> result = dao.listAll();

       
        Assert.assertEquals(2, result.size());

        dao.remove(dvd2.getId());
        result = dao.listAll();

        Assert.assertEquals(1, result.size());

        Assert.assertEquals(null, dao.getById(dvd2.getId()));
    }

    @Test
    public void listAll() {
      
        dao.add(dvd1);
        dao.add(dvd2);
        dao.add(dvd3);
        
        List<DVD> result = dao.listAll();
        
        Assert.assertEquals(3, result.size());
        Assert.assertEquals("Joss Whedon", result.get(0).getDirector());
        Assert.assertEquals("Quentin Tarantino", result.get(1).getDirector());
        Assert.assertEquals("JJ Abrams", result.get(2).getDirector());
    }

    @Test
    public void getById() {
    
        dao.add(dvd1);
        dao.add(dvd2);
        dao.add(dvd3);

        DVD result1 = dao.getById(dvd1.getId());
        DVD result2 = dao.getById(dvd2.getId());
        DVD result3 = dao.getById(dvd3.getId());
       
        Assert.assertEquals("Joss Whedon", result1.getDirector());

    }

    @Test
    public void getByTitle() {

        dao.add(dvd2);

        List<DVD> result = dao.getByTitle("Pulp Fiction");
        System.out.println(result);

        Assert.assertEquals(dvd2, result.get(0));
        Assert.assertEquals("Quentin Tarantino", result.get(0).getDirector());

    }

    @Test
    public void getByRating() {
       
        dao.add(dvd1);

        List<DVD> result = dao.getByRating("PG13");

        Assert.assertEquals(dvd1, result.get(0));
        Assert.assertEquals("Joss Whedon", result.get(0).getDirector());

    }

    @Test
    public void getByStudio() {
      
        dao.add(dvd1);
        dao.add(dvd2);
        dao.add(dvd3);

        List<DVD> result = dao.getByStudio("Marvel");

        Assert.assertEquals(dvd1, result.get(0));
        Assert.assertEquals("Marvel", result.get(0).getStudio());

    }
}
