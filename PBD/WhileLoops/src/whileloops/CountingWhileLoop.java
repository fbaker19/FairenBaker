/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whileloops;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class CountingWhileLoop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Type in a message, and I'll display it five times.");
        System.out.print("Message: ");
        String message = sc.nextLine();

        int n = 0;
        
        while (n < 10) { //predetermined value
            
            System.out.println((n + 1) + ". " + message); 
            n++;//increments +1  to the next number until predetermined stop ie"10"
            //n+=2 counts up by increments of 2
        }

    }

}
