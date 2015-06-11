/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.refactoredlabs;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class LuckySevensRefactored {

    private Scanner sc = new Scanner(System.in);
    private Random die = new Random();

    private int die1Num; //nouns
    private int die2Num;
    private int dollars;         // initial number of dollars (input)
    private int countRolls;
    private int maxDollars;       // maximum amount held user/new number of dollars
    private int countMaxRolls;

    //count down until player does not have any more $$$   
    private int readUserInputIntRange(String prompt, int min) {
        int userInput = 0;
        boolean done = false;
        while (!done) {
            try {
                do {
                    System.out.println(prompt + " [minimum $" + min + "]");
                    System.out.print("$");
                    userInput = Integer.parseInt(sc.nextLine());
                } while (userInput < min);
                done = true;
            } catch (Exception e) {
                System.out.println("Invalid input, please try again\n");
            }
        }
        return userInput; //userInput pushed int "PlayLuckySevens"
    }


    public void playLuckySevens() {
        dollars = readUserInputIntRange("How much money do you have?",1); //prompt
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
        System.out.println("You are broke after " + countRolls + " rolls. "
                + "You should have quit after " + countMaxRolls
                + " rolls when you had $" + maxDollars);
    }
    public static void main(String[] args) {
        LuckySevensRefactored simplified = new LuckySevensRefactored();
        simplified.playLuckySevens();
                
    }
  
}



