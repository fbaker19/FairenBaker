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
        
        int yourGuess;
        int guess = 1+r.nextInt(10);
       
        
        System.out.println("I'm thinking of a number 1 through 10");
        //String yourGuess;
          
        yourGuess = sc.nextInt();   
        System.out.println("your guess is " + yourGuess );
         
   
            
            if (yourGuess == guess){
                System.out.println("That's right! My secret number was " + guess);
            }else{ System.out.println("Sorry! the number I was actually thinking on was "+ guess);
                    }
    }
}
