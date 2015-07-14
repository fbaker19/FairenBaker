package com.swcguild.contactlistmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {//Defualt controller
    
    @RequestMapping(value = {"/","/home"}, method=RequestMethod.GET)//spring framework, that uses a GET method
    public String displayHomePage()
    {
        return "home";
    }
    
}
