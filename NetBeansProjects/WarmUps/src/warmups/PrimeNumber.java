/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warmups;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class PrimeNumber {
    public static void  main(String[] args){
        
        Scanner sc = new Scanner (System.in);
    
    
    System.out.println("Hello, this program will factorize a number you have entered. \nThe goal is to find if the number is prime.");
    
   System.out.println("Please enter your number");
        int number= sc.nextInt();
//        
      System.out.println("Your number is " + number);
//    
//      for(int i = number; i>=1; i--){
//          if (number%i == 0);
//          System.out.println(i);
//          
//          
//          //prime number is 1 and itself
//            String y;
//          
//            String n;
//          
//          System.out.println("Do you want to play again - y/n?");
//            
//          
//          
//            if(y){
//                
//                System.out.println("");
//            }
//            
//            if(n){
//               System.out.println("Thanks for playing");
//            }
//      }
//    
//    }
//    
//}
    do{ 
        int value =0;
        String valueString;
            
        while(value<=0){
        
        System.out.println("enter number greater than 0");
        valueString =sc.nextInt();
        value = Integer.parseInt(valueString);
        
        }
        
       int primeCount = 0;
       boolean primeFound = true;
       for(int i=1; 1<=value; i++)
       {
           for(int j=2, j<i; j++)
           {
               if(i%j==0)
           
           
           {
               primeFound =false;
           }
                if(primeFound)
                {
                    System.out.println("prime found" + i);
                    primeCount++;
              
               }
           primeFound = true;
           
           }
           }
        
        
        System.out.println("the prime number is "+  primeCount);
        
        System.out.println("Would you like to enter another number?");
            int num= sc.nextInt();
    
    }while();
    
    }

}