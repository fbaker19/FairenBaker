/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class Makes10Test {
    
    Makes10 m10;
    
    public Makes10Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        m10 = new Makes10();
    }
    
    @After
    public void tearDown() {
    }

   @Test
   public void Makes()
   {
    boolean result;
    
    int a = 9;
    int b = 10;
    
    result = m10.Makes10(a, b);
    Assert.assertTrue(result);
       
   }
   
   @Test
   public void Ten()
   {
       boolean result;
       
       int a = 9;
       int b = 9;
       
       
       result = m10.Makes10(a, b);
       Assert.assertFalse(result);
 
   }
   
   @Test
   public void Makes10()
   {
       boolean result;
       
       int a = 1;
       int b = 9;
       
       result = m10.Makes10(a, b);
       
       Assert.assertTrue(result);
   
   }
   
}
