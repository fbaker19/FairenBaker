/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.junitarrays.MakePI;
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
public class MakePITest {
    
    MakePI mpi;
    
    public MakePITest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mpi = new MakePI();
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
 public void MakePI()
 {
     int result;
 
     new int[]{3,1,4};
     result = mpi.MakePi(result)
     Assert.assertEquals(n, n);
 
 }   
    
}
