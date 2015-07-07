/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbooklambdarefactor.dao;

import com.swcguild.addressbooklambdarefactor.LambdaAddressBookImpl;
import com.swcguild.addressbooklambdarefactor.ui.AddressBook;
import com.swcguild.addressbooklambdarefactor.ui.AddressBook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class LambdaAddressDAOJUnitTest {
    AddressBook faceDao;
    
    public LambdaAddressDAOJUnitTest() {
    }
    
    @Before
    public void setUp() {
        /**
         * cant have a new interface, must call the impl
         */
        faceDao = new LambdaAddressBookImpl();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
   public void addAddress ()
   {
//       expectedOutput
//       actualOutput
   
   }
           
}
