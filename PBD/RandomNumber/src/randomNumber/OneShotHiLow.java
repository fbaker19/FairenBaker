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
public class OneShotHiLow {
    public static void main(String[] args){
        
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
    
    int number = 1+r.nextInt(100);
   
    
    System.out.println("Im thinking of a number 1-100. Please try and guess it");
         int user = sc.nextInt();
         
     if(user == number){
         System.out.println("You guessed it!");
     }
     
     if (user< number){
      System.out.println("Too Low. Sorry, the number I was thinking of was "+ number);
     }
      
     if(user > number){
         
         System.out.println("Too High!!Sorry, the number I was thinking of was "+ number);}
    
    
    }
    
}
