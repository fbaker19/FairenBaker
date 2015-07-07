/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.junitarrays.FirstLast6;
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
public class FirstLast6Test {
    
    FirstLast6 fl6;
    
    public FirstLast6Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        fl6 = new FirstLast6();
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void FirstLast()
    {
        //set
        boolean result;
        int[] numbers = {1,2,6};
        //act
        result= fl6.FirstLast6(numbers);
        //assert
        Assert.assertTrue(result);
        
        int [] numbers2 = {6, 1, 2, 3};
        
        result = fl6.FirstLast6 (numbers2);
        
        Assert.assertTrue(result);
        
        int [] number3 = {13, 6, 1, 2, 3};
       
        result = fl6.FirstLast6 (number3);
       
        Assert.assertFalse(result);
        
    }
   
}
