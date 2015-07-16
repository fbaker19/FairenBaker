/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevenwebapp.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class InterestController {
    
    @RequestMapping(value = {"/", "/interest"}, method  = RequestMethod.GET)
    public String doGet()
    {
        return "interest";
    }
   @RequestMapping (value = {"/interest"}, method = RequestMethod.POST)//RESULT.JSP
    public String doPost(HttpServletRequest request, Model model)
   
    {
        
        float originalBalance = Float.parseFloat(request.getParameter("originalBalance"));//user input
        float currentBalance;

        //The number of years the money is to stay in the fund:
        float numYears = Float.parseFloat(request.getParameter("numYears")); //user input

        float numPeriods=Float.parseFloat(request.getParameter("numPeriods")); //user input
        //Annual interest rate:
        float intRate = Float.parseFloat(request.getParameter("intRate")); //user input

        float annualInterest;

        //Year end new balance:
        float newBalance;
        String message = "";
      //message.append("Your cost without labor is: $<b>" + cost.format(totalCostWithoutLabor) + "</b><br/>");

        int yearCount = 0;

        do {

            newBalance = (float) (originalBalance * (Math.pow(1 + ((intRate * .01) / numPeriods), (numPeriods))));
            annualInterest = (newBalance - originalBalance);
            yearCount++;
            message += "Year " + yearCount;
            message += " - Principal at start of year: "+ originalBalance;
            message += "  Interest earned this year:" + annualInterest;
            message +=  "Principal at end of year:" + newBalance;
           

            originalBalance = newBalance;
        } while (yearCount <= (numYears - 1));

        
        model.addAttribute("message", message);
        return "interestResult";
    }
    
}
