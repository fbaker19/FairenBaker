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
public class LuckySevens {

     public static void main (String [] args) {
  
      Scanner sc = new Scanner(System.in);
      Random r = new Random();
   
      int die1, die2;       
      int dollars;         // initial number of dollars (input)
      int countRolls;           
      int maxDollars;       // maximum amount held user/new number of dollars
      int countMaxRolls;       // count when the max $$$ is achieved

      // user input
      System.out.print("How much money do you have? ");
      dollars = sc.nextInt();
   
      //  variables
      maxDollars = dollars;
      countMaxRolls = 0; 
      countRolls = 0;
   
      //count down until player does not have any more $$$   
      while (dollars > 0) //<---condition
      {
         countRolls++;
     
         die1 = 1+r.nextInt (6); 
         die2 = 1+r.nextInt (6); 
     
         //  winnings or loses
         if (die1 + die2 == 7)
            dollars += 4;
         else 
            dollars -= 1; 
      
         // New maxumin of  $$$  
         if (dollars > maxDollars){
            maxDollars = dollars;
            countMaxRolls = countRolls;
         }
      }
   
      // Display the results
      System.out.println 
         ("You are broke after " + countRolls + " rolls." +
          "You should have quit after " + countMaxRolls +
          " rolls when you had $" + maxDollars);
   }
}