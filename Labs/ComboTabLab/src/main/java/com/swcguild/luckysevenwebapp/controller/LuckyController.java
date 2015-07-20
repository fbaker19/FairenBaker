/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevenwebapp.controller;

import com.swcguild.luckysevenwebapp.model.Luck;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author apprentice
 */
@Controller // sterotype controller??- Default
public class LuckyController {
    private Random die = new Random();
    private int die1Num; //nouns
    private int die2Num;
    private int dollars;         // initial number of dollars (input)
    private int countRolls;
    private int maxDollars;       // maximum amount held user/new number of dollars
    private int countMaxRolls;
    
    //URL
      @RequestMapping(value = {"/lucky"}, method=RequestMethod.GET)//spring framework, that uses a GET method
    public String doGet()
    {
        return "lucky";
    }
    //URL
    //POST  METHODS  ARE USED FOR USER INPUT
     @RequestMapping(value = {"/lucky"}, method=RequestMethod.POST)//spring framework, that uses a POST method
    public String doPost(@ModelAttribute Luck lucksVariable, Model model)//imports DTO /model Luck
    {                                     //incoming DTO   - Out-going: feeds DTO into model>> jsp >>to user
      dollars = lucksVariable.dollars;
        maxDollars = dollars;
        while (dollars > 0) //<---condition
        {
            countRolls++;
            die1Num = die.nextInt(6)+1;
            die2Num = die.nextInt(6)+1;
            //  winnings or loses
            if (die1Num + die2Num == 7) {
                dollars += 4;
            } else {
                dollars -= 1;
            }

            // New maxumin of  $$$  
            if (dollars > maxDollars) {
                maxDollars = dollars;
                countMaxRolls = countRolls;
            }
        }

        // Display the results
        lucksVariable.result = "You are broke after " + countRolls + " rolls. "
                + "You should have quit after " + countMaxRolls
                + " rolls when you had $" + maxDollars;
        model.addAttribute("lucks", lucksVariable);
        return "result";//JSP result pg 
    }
}