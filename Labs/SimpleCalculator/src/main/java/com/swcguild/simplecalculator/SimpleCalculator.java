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
    int userChoice = 0;

    public SimpleCalculator() {
        sc = new Scanner(System.in);//Default constructor
        System.out.println("Please choose a from the following operands:\n1= addition\n2 = subtraction\n3 = multiplication\n4 = division\n5 = Goodbye!");
        userChoice = sc.nextInt();

    }

    private float getUserInput(String prompt) {

        System.out.println(prompt);
        Float ans = sc.nextFloat();

        return ans;
    }

    public void run() { //pushes everything to App
        float userInput = 0;
        float userInput2 = 0;

        

        while (userChoice < 1 || userChoice > 5) {

            //if (!Switch(userInput, userInput2)) {
            System.out.println("You have entered an invalid selection, please enter a number 1-5");
            userChoice = sc.nextInt();
//                

        }
        if (userChoice == 5) {
            System.out.println("Goodbye!");

        }
        
        while (userChoice!=5) {
            userInput = getUserInput("Please put in a float");//scalc.getUserInput is the scanner
            System.out.println(" Your number was " + userInput);

            userInput2 = getUserInput("Please put in another float");//scalc.getUserInput is the scanner
            System.out.println(" Your other number was " + userInput2);

            Switch(userInput, userInput2);
            System.out.println("Would you like to calculate again?\nPlease choose a from the following operands:\n1= addition\n2 = subtraction\n3 = multiplication\n4 = division\n5 = Goodbye");
            userChoice = sc.nextInt();
            
            while (userChoice < 1 || userChoice > 5) {

            //if (!Switch(userInput, userInput2)) {
            System.out.println("You have entered an invalid selection, please enter a number 1-5");
            userChoice = sc.nextInt();
            
            }
            
        }
    }

    public boolean Switch(float userInput, float userInput2) {
        Calculations calc = new Calculations();
        switch (userChoice) {
            case 1:

                float result = calc.addition(userInput, userInput2);
                System.out.println("Your result is " + result);
                break;

            case 2:

                result = calc.subtraction(userInput, userInput2);
                System.out.println("Your result is " + result);
                break;

            case 3:
                result = calc.multiply(userInput, userInput2);
                System.out.println("Your result is " + result);
                break;

            case 4:
                result = calc.divide(userInput, userInput2);
                System.out.println("Your result is " + result);
                break;

            default:
                System.out.println("Goodbye!");
                return false;

        }
        return true;// boolean returning "switch statment" 
    }
}
