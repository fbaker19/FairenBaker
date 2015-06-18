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
public class GreatParty2Test {
    
    GreatParty2 gp2;
    
    public GreatParty2Test() {
    }
    
 
    
    @Before
    public void setUp() {
        
        gp2 = new GreatParty2();
   
    }
    
   @After
    public void tearDown() {
    }

  @Test
  public void Great()
  {
      boolean result;
      
      int cigars = 30; 
      boolean isWeekend = true;
      
      result = gp2.GreatParty(cigars, isWeekend);
      Assert.assertFalse(result);
  
  }
  
  @Test
  public void Party()
  {
      boolean result;
      
      int cigars = 50;
      boolean isWeekend = false;
      
      result = gp2.GreatParty(cigars, isWeekend);
      Assert.assertTrue(result);
  }
  
  
  @Test
  public void GreatParty2()
  {
      boolean result;
      
      int cigars = 70 ;
      boolean isWeekend = true;
      
      result = gp2.GreatParty(cigars, isWeekend);
      Assert.assertTrue(result);
  
  }
  
}
