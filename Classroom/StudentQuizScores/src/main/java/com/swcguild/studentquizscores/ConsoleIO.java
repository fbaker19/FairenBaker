/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.studentquizscores;

import java.util.Scanner;

public class ConsoleIO {

    private Scanner sc;// = new Scanner(System.in);

    public ConsoleIO() {
        sc = new Scanner(System.in);//Default constructor

    }

    //METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS !!!!!!!!!


// 1. Display a prompt to the user and read in an integer. The prompt value should be passed
//in as a parameter and the value that is read in should be the return value of the method.
    public int getInteger(String prompt) {
        System.out.println(prompt);
        int userAns = sc.nextInt();
        return userAns;
    }



//2. Display a prompt to the user and read in an integer between max val and min val. The
//prompt value, min, and max should be passed in as parameter. The value read in from
//the console should be the return value of the method. This method must keep asking
//the user for input until the value is in range.
   
    public int readUserInputIntRange(String prompt, int min, int max) {
        int userInput = 0;
        boolean done = false;
        while (!done) {
            try {
                do {
                    System.out.println(prompt + " [minimum " + min + ": maximum " + max + "]");
                    userInput = Integer.parseInt(sc.nextLine());
                } while (userInput < min || userInput > max);
                done = true;
            } catch (Exception e) {
                System.out.println("Invalid input, please try again\n");
            }
        }
        return userInput;
    }
       
    
    
    
    // 3.Display a prompt to the user and read in a String. The prompt value
    //   should be passed in as a parameter and the value that is read in should
    //   be the return value of the method.

    public String stringPrompt(String prompt) {
        System.out.println(prompt);
        String ans = sc.nextLine();
        return ans;
    }

    
    
    
//  4. Display a prompt to the user and read in a float. The prompt value should
//  be passed in as a parameter and the value that is read in should be the
//  return value of the method.
    public float floatPrompt(String prompt) {
        System.out.println(prompt);
        Float ans = sc.nextFloat();
        return ans;
    }
    
    
    
    
//   5. Display a prompt to the user and read in a float between max val and min
//  val. The prompt value, min, and max should be passed in as parameter. The
//  value read in from the console should be the return value of the method. This
//  method must keep asking the user for input until the value is in range.
// 
    public float readUserInputFloatRange(String prompt, float min, float max) {
        float userInput = 0;
        boolean done = false;
        while (!done) {
            try {///first part of the catch/exception
                do {
                    System.out.println(prompt + " [minimum " + min + ": maximum " + max + "]");
                    userInput = Float.parseFloat(sc.nextLine());
                } while (userInput < min || userInput > max);
                done = true;
            } catch (Exception e) {//catches exceptions outside the parameter ie"bob"
                System.out.println("Invalid input, please try again\n");
            }
        }
        return userInput;
    }
    
    
    
     //6. Display a prompt to the user and read in a double.
 
     public double doublePrompt(String prompt) {
        System.out.println(prompt);
        double ans = sc.nextDouble();
        return ans;
    }

     
     
     
//  7. Display a prompt to the user and read in a double between max val and min
//  val. The prompt value, min, and max should be passed in as parameter. The
//  value read in from the console should be the return value of the method. This
//  method must keep asking the user for input until the value is in range.
 
     
      public double readUserInputDoubleRange(String prompt, double min, double max) {
        double userInput = 0;
        boolean done = false;
        while (!done) {
            try {
                do {
                    System.out.println(prompt + " [minimum " + min + ": maximum " + max + "]");
                    userInput = Double.parseDouble(sc.nextLine());
                } while (userInput < min || userInput > max);
                done = true;
            } catch (Exception e) {
                System.out.println("Invalid input, please try again\n");
            }
        }
        return userInput;
    }

      
      
      
//  8. Print a given String to the console. The prompt value should be passed in
//  as a parameter.
     public String getString(String prompt) {
        System.out.println(prompt);
        String userAns = sc.nextLine();
        return userAns;
    }  
      
}
