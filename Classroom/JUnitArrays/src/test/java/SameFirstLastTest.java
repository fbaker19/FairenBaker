/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.junitarrays.SameFirstLast;
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
public class SameFirstLastTest {
    
    SameFirstLast sfl;
    
    public SameFirstLastTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sfl = new SameFirstLast();
    }
    
    @After
    public void tearDown() {
    }

   
     @Test
     
     public void SameFirstLast()
     {
         boolean result;
          
         int[] num = {1, 2, 3};
          
         result = sfl.SameFirstLast(num);         
         Assert.assertFalse(result); 
         
         
         int [] num2 = {1, 2, 3, 1};
         
         result = sfl.SameFirstLast(num2);
         Assert.assertTrue(result);
         
         int[] num3 = {1, 2, 1};
         
         result = sfl.SameFirstLast(num3);
         Assert.assertTrue(result);
         
     }
}