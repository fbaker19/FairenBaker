/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucky7;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Lucky7 {

     public static void main (String [] args) {
  
      Scanner sc = new Scanner(System.in);
      Random r = new Random();
   
      int die1, die2;       
      int dollars;         // initial number of dollars (input)
      int count;           
      int maxDollars;       // maximum amount held user
      int countAtMax;       // count when the max is achieved

      // user input
      System.out.print("How many dollars do you have? ");
      dollars = sc.nextInt();
   
      //  variables
      maxDollars = dollars;
      countAtMax = 0;
      count = 0;
   
      //count down until player does not have any more $$$   
      while (dollars > 0){
         count++;
     
         
         die1 = 1+r.nextInt (6); 
         die2 = 1+r.nextInt (6); 
     
         //  winnings or loses
         if (die1 + die2 == 7)
            dollars += 4;
         else 
            dollars -= 1; 

      
         // If this is a new maximum, remember it  
         if (dollars > maxDollars){
            maxDollars = dollars;
            countAtMax = count;
         }
      }
   
      // Display the results
      System.out.println 
         ("You are broke after " + count + " rolls.\n" +
          "You should have quit after " + countAtMax +
          " rolls when you had $" + maxDollars + ".");
   }
}