/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardinput;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ForgetfulMachine {
       public static void main(String[] args){
    
		Scanner keyboard = new Scanner(System.in);

		int number;
                int number2;
		String word;
                String word2;
		

		System.out.print( "Word number 1!" );
		word = keyboard.next();

		System.out.print( "Word number 2! " );
		word2 = keyboard.next();
                
                System.out.print( "Pick a number! Any Number! " );
		number = keyboard.nextInt();
                
                System.out.print( "Pick a number! Any Number Again!!! " );
		number2 = keyboard.nextInt();
 
 
       }
}
