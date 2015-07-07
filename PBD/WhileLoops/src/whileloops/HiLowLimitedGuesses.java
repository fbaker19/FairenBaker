/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whileloops;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class HiLowLimitedGuesses {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int compGuess = 1 + r.nextInt(100);
        int tries = 0;

        System.out.println("Please enter a number 1 - 100");
        int user = sc.nextInt();
        tries++;//count#1 (outside the while loop/first entry/userInput)
        
        
        while (compGuess != user && tries < 7) {

            if (compGuess > user) {
                System.out.println("Sorry! Your number was too low. Please guess again");
                user = sc.nextInt();
                
            } else if (compGuess < user) {
                System.out.println("Sorry! Your guess was too high! Please try again");
                user = sc.nextInt();
            }
//            else if(tries >=7)
//       {
//           System.out.println("Sorry, too many guesses");
//       }
            tries++;
        }
        if (tries >= 7) {
            System.out.println("Sorry, too many guesses");
        }else{
        System.out.println("You guessed it! What are the odds!");
        }
    }

}
