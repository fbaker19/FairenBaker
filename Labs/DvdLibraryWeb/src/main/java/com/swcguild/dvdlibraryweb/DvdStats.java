/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class DvdStats {
      @RequestMapping(value = "/dvdStats", method=RequestMethod.GET)//refers to spring framework
    public String displayStatsPage()
    {
        return "dvdStats";
    }
    
}