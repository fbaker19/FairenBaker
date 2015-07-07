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
public class PINLockout {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
       int pin = 122333;
       int tries =0; //counter
       
        System.out.println("Welcome to the bank of Akron");
        System.out.println("Please enter your PIN");
       int pinEntry = sc.nextInt();
       tries++;
       
       while(pin != pinEntry && tries < 3)//kicks you out after 3 tries
       {
           System.out.println("WRONG ENTRY. PLEASE TRY AGAIN.");
           System.out.println("Please enter the correct PIN");
           pinEntry = sc.nextInt();
           tries++;
       
       }
       if(pin ==pinEntry)
       {
           System.out.println("PIN is correct! Welcome!!!");
       }else if(tries >=3)
       {
           System.out.println("UNSUCCESFULL PIN ENTRY. FUTURE ENTRY DENIED \nACCOUNT IS NOW LOCKED");
       }
       
    }
    
}
