/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevenwebapp.controller;

import static javax.management.Query.value;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class FloorController {

    @RequestMapping(value = {"/floor"}, method = RequestMethod.GET)
    public String doGet() {
        return "floor";
    }

    @RequestMapping(value = {"/floor"}, method = RequestMethod.POST)
    public String doPost(HttpServletRequest request, Model model) {
        float width = Float.parseFloat(request.getParameter("width"));
        float length = Float.parseFloat(request.getParameter("length"));

        float sqFtPerQt = 5;//sqft==area
        float costPerQt = (float) 21.5;

        String message = "";

    //every 15 min -  put down 5 sqft
        //5sqft = 21.50 per 15min
       
        float area = (length * width);

        message += " Your area is: " + area;
//   
//    if(area <=4)
//    {
//        System.out.println( Math.floor(area));
//    }else{
//        System.out.println( Math.ceil(area));
//    }

        float newArea = (float) (5 * (Math.ceil(Math.abs(area / 5))));///rounds to nearest whole number then * by 5
        message += " \nnew area: " + newArea;

        float totalCost = (newArea * costPerQt) / 5;///divideds cost by quarter

        message += " \ntotal cost is: " + totalCost;

        model.addAttribute("message", message);
        return "floorResult";
    }

}
