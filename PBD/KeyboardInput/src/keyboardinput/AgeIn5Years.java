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
public class AgeIn5Years {
    public static void main(String[] args){
        int age;
        String name;
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Hello. What is your name? ");
        name = sc.nextLine();
        System.out.println("Hi, " + name + "! How old are you?");
        age = sc.nextInt();
        
        System.out.println("Did you know that in five years you will be " + (age + 5) +" years old");
        System.out.println("And five years ago you were " + (age - 5) + "! Imagine that");
        
        
    
    
    
    }
}
