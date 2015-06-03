/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomNumber;

import java.util.Random;

/**
 *
 * @author apprentice
 */

public class Randomness {
    public static void main(String[] args) {
    

    Random r = new Random();
    
    int x = 1 + r.nextInt(10);
    
    System.out.println("My random number is " + x);
    
    System.out.println("Here's my number 1 to 5!");
    System.out.print(1+r.nextInt(5)+ " ");
    System.out.print(1+r.nextInt(5)+ " ");
    System.out.print(1+r.nextInt(5)+ " ");
    System.out.print(1+r.nextInt(5)+ " ");
    System.out.print(1+r.nextInt(5)+ " ");
    System.out.println();
    
    
    System.out.println("Here are random numbers 1 to 100!");
    System.out.print(1+r.nextInt(100)+ "\t ");
    System.out.print(1+r.nextInt(100) +"\t ");
    System.out.print(1+r.nextInt(100)+ "\t ");
    System.out.print(1+r.nextInt(100) +"\t");
    System.out.print(1+r.nextInt(100)+ "\t ");
    System.out.print(1+r.nextInt(100) +" ");
    System.out.print(1+r.nextInt(100)+ " ");
    System.out.print(1+r.nextInt(100) +" ");
    System.out.println();
    
    int num1 = 1+ r.nextInt(10);
    int num2 = 1+ r.nextInt(10);
    
    if(num1==num2){
        System.out.println("The random numbers printed out the same! Weird!");
       
    }
    
    if(num1!= num2){
        System.out.println("The random numbers were different, not suprising, actually");
    
    }    
        
    }
}
