
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
public class Diff21Test {
    
    Diff21 d21;
    
    public Diff21Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        d21 = new Diff21();
    }
    
    @After
    public void tearDown() {
    }
    
    
//example set up for non-boolean conditional

     @Test
    public void Diff21()
    {  
        int result = d21.Diff21(23);
        Assert.assertEquals(result, 4);
    }
    @Test
    public void Dif21()
    {
        int result = d21.Diff21(10);
        Assert.assertEquals(result, 11);
    }
    
    @Test
    public void Df21()
    {
        int result = d21.Diff21(21);
        Assert.assertEquals(result,0);
    
    }
}
