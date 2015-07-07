/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.junitarrays.CommonEnd;
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
public class CommonEndTest {
    
    CommonEnd ce;
    
    public CommonEndTest() {
    }
    
    @Before
    public void setUp() {
        ce = new CommonEnd();
    }
    
    @After
    public void tearDown() {
    }

    
     @Test
     public void CommonEnd()
     {
         boolean result;
         
         int [] numA = {1, 2, 3}; 
         int [] numB =  {7, 3};
         
        result = ce.commonEnd(numA,numB);
        Assert.assertTrue(result);
        
       // Assert.assertTrue(ce.commonEnd(new int[]{1,2,3}, new int[]{7,3}));
         
     }

}
