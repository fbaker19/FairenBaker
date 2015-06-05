/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBasicsSkillCheck;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Adder {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Please enter a number");
            int num1 = sc.nextInt();
            System.out.println("The number you have chosen is " +num1);
        
            System.out.println("Please enter another number");
            int num2 = sc.nextInt();
            System.out.println("The second number you have chosen is "+num2);
        
            int sum =(num1 + num2);
            System.out.println("The sum of your numbers is "+ sum);
        
        
    }
    
}
