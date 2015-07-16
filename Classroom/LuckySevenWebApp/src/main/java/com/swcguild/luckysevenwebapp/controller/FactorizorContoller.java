/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevenwebapp.controller;

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
public class FactorizorContoller {
 
    @RequestMapping(value = {"/factor"}, method = RequestMethod.GET)
    public String displayFactorizor()
    {
        return "factor";//JSP NAMES
    }
    
    @RequestMapping(value = {"/factor"}, method = RequestMethod.POST)//action attribute(factor)
    public String resultFactorizor(HttpServletRequest request, Model model)
   
    {
      
 
        int inputNum = Integer.parseInt(request.getParameter("inputNum"));
        int sumOfFactors = 0 ;
        String message ="";//intialize variable "message" is being called by result.POST jsp
        
        // "Please enter the number you want to factor:" ;
        
        message += "You entered " + inputNum;
       
        message += "The factors of " + inputNum + " are: ";
      
         for (int i = 1; i < inputNum; i++) {
            if (inputNum % i == 0) {
                
                sumOfFactors = sumOfFactors + i;
            }
        }
        //message = (Integer.parseInt(inputNum));

        if (sumOfFactors == inputNum) {
             message +=inputNum + " is a perfect number";
        } else {
             message += inputNum + " is not a perfect number";
        }

        if (sumOfFactors == 1) {
            message += inputNum + " is a prime number";
        } else {
             message += inputNum + " is not a prime number";
        }


        model.addAttribute("message", message);
      
        return "factorResult";///JSP NAMES
    }
}
