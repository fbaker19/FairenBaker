/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.olympian.SkiJumper;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class OlympianTest {

    public OlympianTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void SkiJumperTest() {
        SkiJumper jumper = new SkiJumper();//import skijumper class
        assertEquals(jumper.competeInEvent(), "SkiJump");
    }
    
    @Test
    public void SpringSkiJumper()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SkiJumper sj = ctx.getBean("superSkiJumper", SkiJumper.class);
        assertEquals("SkiJump", sj.competeInEvent());
    }
}
