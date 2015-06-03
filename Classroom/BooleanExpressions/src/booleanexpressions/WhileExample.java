/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanexpressions;

import java.util.Scanner;
import static sun.font.GlyphLayout.done;

/**
 *
 * @author apprentice
 */
public class WhileExample {
    
    static public void main(String[] args,){
    
       Scanner sc = new Scanner(System.in);

       int userInput;
       
       while(!done){

      
        System.out.println("Please enter the following");
        System.out.println("1 for Hello World");
        System.out.println("2 for I love Akron");
        System.out.println("3 for I love Java");
        System.out.println("4 to quit");

        userInput = sc.nextInt();

        switch(userInput){
            case 1:
                 System.out.println("Hello World!");
                 break;
            case 2: 
                System.out.println("I love Akron!");
                break;

            case  3:
                System.out.println("I Love Java!");
                break;
            case 4:
                System.out.println("Thank you for playing!");
                done = true;
                break;
            default: 
                System.out.println("Please print a valid value!");
                break;

        } 

       }
   
    
    }
    
}
