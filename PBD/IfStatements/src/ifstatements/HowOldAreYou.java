/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifstatements;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class HowOldAreYou {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
    
   int age; 
   
   System.out.println("how old are you?");
    age =sc.nextInt();
   
   if(age < 16){
   
   System.out.println("You can't drive! Loser!");
   }
    
   if(age < 18){
   System.out.println("You can't vote!");
   }
   
   if(age < 25){
   System.out.println("You can't rent a car");
   }
    
   if(age > 25){
      System.out.println ("You can do anything legal...or illegal if you don't get caught.");
               }
   
    }
    
}
