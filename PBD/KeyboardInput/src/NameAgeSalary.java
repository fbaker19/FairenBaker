
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class NameAgeSalary {
        public static void main(String[] args){
    
		Scanner keyboard = new Scanner(System.in);

		int age;
		String name;
		double salary;

		System.out.print( "What's your name? " );
		name = keyboard.next();

		System.out.print( "How old are you? " );
		age = keyboard.nextInt();
                
                System.out.print( "How much money do you make? " );
		salary = keyboard.nextDouble();
    
    }
    
}
