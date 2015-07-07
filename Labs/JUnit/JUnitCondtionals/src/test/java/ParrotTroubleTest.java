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
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class ParrotTroubleTest {
   ParrotTrouble pt;
   
    public ParrotTroubleTest() {
    }
    
    @Before
    public void setUp() {
        pt = new ParrotTrouble();
    }
    
    @After
    public void tearDown() {
    }

   @Test
   public void Parrot()
   { 
       boolean result;
       boolean isTalking = true; 
       int hour = 6;
       
       result = pt.ParrotTrouble(isTalking, hour);
       Assert.assertTrue(result);
   
   }
   
   @Test
   public void Trouble()
   { 
       boolean result;
       
       boolean isTalking = true;
       int hour = 7;

       result = pt.ParrotTrouble(isTalking, hour);
       Assert.assertFalse(result);
       
   }
   @ Test
   public void ParrotTrouble()
   {
       boolean result;
       
       boolean isTalking = false;
       int hour = 6;
       
       result = pt.ParrotTrouble(isTalking, hour);
       Assert.assertFalse(result);
   
   }
   
}
