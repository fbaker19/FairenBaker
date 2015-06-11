/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.swcguild.unittest.GreatParty;
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
public class SampleUnitTest {
    
      
        
    private GreatParty myParty; 
      
    
    
    @BeforeClass
    public static void setUpClass() {
 
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        myParty = new GreatParty();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test //Juit runs this as a test, make sure1st letter is capitalized
    public void greatPartyTest()//void "no return value needed"
    {
      
        //GreatParty myParty = new GreatParty();
        boolean result;
        result= myParty.greatParty(30,false);
        
        Assert.assertFalse(result);
        
        
        result = myParty.greatParty(50, false);
        Assert.assertTrue(result);
        
        
        result = myParty.greatParty(70, true);
        Assert.assertTrue(result);
        
        
        result = myParty.greatParty(20, true);
        Assert.assertFalse(result);
         
    }
    
    @Test
    public void greatPartyWith30Weekday()
    {
    
      boolean result;
      {
      result = myParty.greatParty(30, false);
      Assert.assertFalse(result);
              }
    }
        
//     @Test
////    public void greatPartyWith20CiagarsAndWeekday()
////    {
////        boolean result;
////      {
////      result = myParty.greatParty(20, true);
////      Assert.assert(result);
////              }
////        
//    }
    
 @Test
 public void numberOfGuest(){
int result =  myParty.numberOfGuest();

Assert.assertEquals(20,result);
Assert.assertTrue(result > 15 && result < 50);
}
    
}
