/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplecalculator;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SimpleCalculator {
    
   private Scanner sc;

    public SimpleCalculator() {
        sc = new Scanner(System.in);//Default constructor

    }  
    
    //i want this to do basic math
    //it needs to add, sub, mult, divide
    // take two user inputs and perform a method
    //
    
    
//   private float operand1;
//   private float operand2;
    
   private float getUserInput(String prompt)
  {
   
      System.out.println(prompt);
        Float ans = sc.nextFloat();
      
        return ans;
  } 
    
   
   
public void run(){ //pushes everything to App

        
        //new variable in the main==. can be anything
        float userInput = getUserInput("Please put in a float");//scalc.getUserInput is the scanner
        System.out.println(" Your number was "+ userInput);
       
        float userInput2 = getUserInput("Please put in another float");//scalc.getUserInput is the scanner
        System.out.println(" Your other number was "+ userInput2);
        
        
        Calculations calc = new Calculations();
        float result = calc.addition(userInput, userInput2); 
        System.out.println("Your numbers added together are " + result);

    }

}
   
   

