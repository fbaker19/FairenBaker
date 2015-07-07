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
public class BMICalc {
    public static void main (String[] args)
    {
        Scanner sc= new Scanner(System.in);
        float height;
        float weight;
        
        System.out.println("Enter your height in inches");
        height=sc.nextFloat();
        
        System.out.println("Enter your weight in ");
        weight=sc.nextFloat();
        
        System.out.println("Your height is: " + height);
        System.out.println("Your weight is: " + weight);
        System.out.println("Your BMI is: " + (weight)/(height*height));
    }
}
