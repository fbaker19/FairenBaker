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
public class NumberGuessingWithCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int guess = 1 + r.nextInt(10);
        int tries = 1;
        

        System.out.println("I'm thinking of a number 1 - 10. Guess until you get it.");
        int player = sc.nextInt();

        //player's anwser is =/= the random number, then the loop will repeat
        
        while (player != guess) {
            System.out.println("Wrong! Guess again!");
            player = sc.nextInt();
            tries++;//counts user/player input
        }
    //when deseired # is reached, break the loop

        System.out.println("Wow you guessed it! Whoo! You were right!\nIt took you "+tries+ " tries to guess");
     

    }
}
