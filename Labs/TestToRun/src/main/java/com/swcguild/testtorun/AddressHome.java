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
public class AddressHome {
  
    @RequestMapping(value = {"/","/addressHome"}, method=RequestMethod.GET)//spring framework, that uses a GET method
    public String homePage()
    {
        return "addressHome";
    }  
}
