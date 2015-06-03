/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomNumber;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class NumGuessGame {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        int guess = 1+r.nextInt(10);
        int yourGuess = 0;
        
        System.out.println("I'm thinking of a number 1 through 10");
            System.out.println("your guess is " + yourGuess );
            yourGuess=sc.nextInt();
   
    }
}
