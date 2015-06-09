/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.rpsrefactored;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RPSRefactored {

    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();
    static int userWins = 0;
    static int compWins = 0;
    static int ties = 0;

    public static int userInputValidationInt(String prompt, int minVal, int maxVal) {
        int result = 0;
        boolean done = false;
        while (!done) {
            try {
                do {
                    System.out.println(prompt + " [min: " + minVal + ", max: " + maxVal + "]");
                    result = Integer.parseInt(sc.nextLine()); // reads strings & pareses them as integers
                } while (result < minVal || result > maxVal);
                done = true;
            } catch (Exception e) {
                System.out.println("invalid input");
            }
        }

        return result;
    }

    public static void humanVsComputer(int userChoice) {
        int computerChoice = 1 + r.nextInt(3);
        System.out.println("Computer choice is " + computerChoice);

        if (userChoice == computerChoice) {
            System.out.println("It's a tie!!!");
            ties++; //counter
        } else if ((userChoice == 1 && computerChoice == 2) || (userChoice == 2 && computerChoice == 3) || (userChoice == 3 && computerChoice == 1)) {
            System.out.println("Computer Wins!!!!!");
            compWins++;//counter
        } else {
            System.out.println("Human Wins!!!!");
            userWins++;//counter
        }

    }

    public static void results() {
        System.out.println("Human score is " + userWins);
        System.out.println("Computer score is " + compWins);
        System.out.println("Ties " + ties);
    }

    public static void finalResults() {
        if (userWins > compWins) {
            System.out.println("Human wins overall");
        } else if (userWins < compWins) {
            System.out.println("Computer wins overall!");
        } else {
            System.out.println("The final score is a draw");
        }
    }

    public static void main(String[] args) {
        int rounds = userInputValidationInt("How many rounds would you like to play?", 1, 10);
        while (rounds > 0) {

            int userChoice = userInputValidationInt("Please choose a number, 1 = rock, 2 = paper, 3 = scissors ", 1, 3);

            humanVsComputer(userChoice); //pass method/user choice

            results();// call results into the loop

            rounds--;// counts fown to 0, after user input ---> breaks loop
        }
        finalResults(); //outside the while loop
    }
}
