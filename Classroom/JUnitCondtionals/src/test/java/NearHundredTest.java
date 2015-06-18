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
public class NearHundredTest {
    
    NearHundred nh;
    
    public NearHundredTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
       nh = new NearHundred();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void Near()
    {
        boolean result;
        
        int value1 = 103;
        
        result = nh.NearHundred(value1);
        Assert.assertTrue(result);    
    }
    
    
    @Test
    public void Hundred()
    {
        boolean result;
    int value1 = 90;
        
        result = nh.NearHundred(value1);
        Assert.assertTrue(result);
    }
    
    
    @Test
    public void NearHundred()
    {
        boolean result;
        int value1 = 89;
        
        result = nh.NearHundred(value1);
        Assert.assertFalse(result);
    
    }
    
    
}
