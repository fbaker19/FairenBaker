/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.testtorun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */

@Controller

public class AddressSearch {
 @RequestMapping(value ="/addressSearch",method=RequestMethod.GET)
 public String displaySearch()
         
 {
     return "addressSearch";//JSP
 }
    
}