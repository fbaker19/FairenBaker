/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.consoleio;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        
       int userInput = io.readUserInputIntRange("please put in a integer",1,5);
         System.out.println("You entered "+ userInput);  
        
        double userInputD = io.readUserInputDoubleRange("please put in a double",1,5);
        System.out.println("You entered "+ userInputD);  
        
        
        
       //float ans = io.floatPrompt("please enter a float");
    }
}