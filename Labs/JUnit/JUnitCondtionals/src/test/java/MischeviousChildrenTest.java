/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class MischeviousChildrenTest {
    MischeviousChildren mc;
    
    
    public MischeviousChildrenTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    mc = new MischeviousChildren();
    
    }
    
    @After
    public void tearDown() {
    }

    
     @Test
     
     public void MischeviousChildren()
     {
     boolean result;
     
     boolean smileA = true;
     boolean smileB = true;
     
     
     result =mc.AreWeInTrouble(smileA, smileB);
     Assert.assertTrue(result);
     
     
     
      boolean noSmile1 = true;
      boolean noSmile2 = true;
     
     
     result = mc.AreWeInTrouble(noSmile1, noSmile2);
     Assert.assertTrue(result);
     
     
      boolean Smile = true;
      boolean noSmile = false;
     
     
     result = mc.AreWeInTrouble(Smile, noSmile);
     Assert.assertFalse(result);
     
     
     }
    
}
