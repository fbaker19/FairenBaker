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
public class WhatIsYourNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter a integer");
        int integer = sc.nextInt();
        
        System.out.println("Your number is " +integer);
        
        for(int i = 0; i< 11; i++) // how would you make this too infinity? array?
        {
            System.out.println(i);
        }
    }
    
}
