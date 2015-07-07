/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.junitarrays.SleepIn;
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
public class SleepInTest {
    SleepIn si;
    public SleepInTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        si = new SleepIn();
    }
    
    @After
    public void tearDown() {
    }

    @Test
 public void SleepIn(){
 
     boolean result;
 
 boolean isWeekday = false;
 boolean isVacation = false;
 
 result = si.CanSleepIn(isWeekday, isVacation);
 Assert.assertTrue(result);
 
 
 
 boolean isWeekday2 = true;
 boolean isVacation2 = false;
 
 result = si.CanSleepIn(isWeekday2, isVacation2);
 Assert.assertFalse(result);
 
 
 
 
 
 boolean isWeekday3 = false;
 boolean isVacation3 = true;
 
 result = si.CanSleepIn(isWeekday3, isVacation3);
 Assert.assertTrue(result);
 
 }
}
