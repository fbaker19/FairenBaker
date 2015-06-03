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
public class DumbCalc {
    
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
    
        float number1;
        float number2;
        float number3;
        
System.out. println("What is your first number?");
number1 = sc.nextFloat();

System.out.println("What is your second number?");
number2 = sc.nextFloat();

System.out.println("What is your 3rd number?");
number3 = sc.nextFloat();

System.out.println("Your numbers add together and divided by two are " 
        + (number1 + number2 + number3)/2);       
        
    
    
    }
    
}
