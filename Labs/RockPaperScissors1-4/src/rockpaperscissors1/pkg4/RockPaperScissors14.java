/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors1.pkg4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RockPaperScissors14 {

    public static void playRPS() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Rock, Paper, Scissors");
        System.out.println("How many rounds would you like to play? [1-10]");
        int rounds = sc.nextInt();
        int countRounds = 0;
        int ties = 0;
        int compWins = 0;
        int userWins = 0;
        if ((rounds >= 1) && (rounds <= 10)) {
            do {
                System.out.println("Please choose '1' for Rock '2' for Paper or '3' forScissors");
                Random r = new Random();
                int userInput = sc.nextInt();
                int computerInput = 1 + r.nextInt(3);
                final int rock = 1;
                final int paper = 2;
                final int scissors = 3;
                switch (userInput) {
                    case rock:
                        if (computerInput == 1) {
                            System.out.println("The computer selected Rock, it's a tie!");
                            ties++;
                        }
                        if (computerInput == 2) {
                            System.out.println("The computer selected Paper, you lose!");
                            compWins++;
                        }
                        if (computerInput == 3) {
                            System.out.println("The computer selected Scissors, you win!");
                            userWins++;
                        }
                        break;
                    case paper:
                        if (computerInput == 1) {
                            System.out.println("The computer selected Rock, you win!");
                            userWins++;
                        }
                        if (computerInput == 2) {
                            System.out.println("The computer selected Paper, it's a tie!");
                            ties++;
                        }
                        if (computerInput == 3) {
                            System.out.println("The computer selected Scissors, you lose!");
                            compWins++;
                        }
                        break;
                    case scissors:
                        if (computerInput == 1) {
                            System.out.println("The computer selected Rock, you lose!");
                            compWins++;
                        }
                        if (computerInput == 2) {
                            System.out.println("The computer selected Paper, you win!");
                            userWins++;
                        }
                        if (computerInput == 3) {
                            System.out.println("The computer selected Scissors, it's a tie!");
                            ties++;
                        }
                        break;
                    default:
                        System.out.println("Please select a valid number! [1, 2 or 3]");
                }
            } while (++countRounds < rounds);
            System.out.println("You won " + userWins + " times!");
            System.out.println("You lost " + compWins + " times!");
            System.out.println("You tied the computer " + ties + " times!");
            if (userWins > compWins) {
                System.out.println("You are the overall winner!");
            } else if (userWins < compWins) {
                System.out.println("The computer is the overall winner, sorry, better luck next time!");
            } else {
                System.out.println("You tied the computer!");
            }
        } else {
            System.out.println("You have selected an invalid number of rounds. Good day!");
        }
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Would you like to play again? [y,n]");
        String input = sc2.nextLine();
        if (input.equalsIgnoreCase("y")) {
            playRPS();
        } else {
            System.out.println("Thanks for playing!");
        }
    }

    public static void main(String[] args) {
        playRPS();
    }
}
