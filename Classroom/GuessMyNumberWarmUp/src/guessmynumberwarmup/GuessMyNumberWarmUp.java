/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessmynumberwarmup;

import java.util.Random;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class GuessMyNumberWarmUp {

    public static void GMN() {

        /**
         * @param args the command line arguments
         */
        //public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        int userInput;
        int compNum = 1 + r.nextInt(10);
        int count = 0;

        do {

            System.out.println("Please enter a number 1 - 10");
            userInput = sc.nextInt();

            count++;
            if (userInput > compNum) {
                System.out.println("Guess again, your number was too high");
            } else if (userInput < compNum) {
                System.out.println("Guess again, your number was too low");
            } else {
                System.out.println("You are correct");
            }
        } while (userInput != compNum);

        System.out.println("You guessed correct! The number was " + compNum);
        System.out.println("it took you " + count + " times to guess correctly");

        //Scanner sc2 = new Scanner (System.in);
        System.out.println("Please enter a valid number, 1-10");
        userInput = sc.nextInt();

        if ((userInput < 1) && (userInput > 10)) {
            System.out.println("The number you enter is out of range,\nplease enter a number 1-10");
        } else {
            System.out.println("Thanks for your input! Your number is " + userInput);
        }
    }

    public static int validateUserInputInt(String prompt, int min, int max) {

        Scanner sc = new Scanner(System.in); //1. import scanner

        int result = 0;
        do {

            System.out.println(prompt); // 2. set up the prompt

            String stringInput = sc.nextLine(); //3. set up user response

            
        } while (result < min || result > max);// user result range
        return result;

    }
    
    public static void main(String[] args) {
        GMN();
    }

}
