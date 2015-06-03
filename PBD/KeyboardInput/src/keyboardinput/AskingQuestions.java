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
public class AskingQuestions {
    public static void main(String[] args){
    
		Scanner keyboard = new Scanner(System.in);

		int age;
		String height;
		double coffeeSugars;

		System.out.print( "How old are you? " );
		age = keyboard.nextInt();

		System.out.print( "How tall are you? " );
		height = keyboard.next();
                
                System.out.print( "How much sugar in your coffee? " );
		coffeeSugars = keyboard.nextDouble();
    
    }
}