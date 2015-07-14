/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.refactoredlabs;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FactorizerRefactored {
    
    public static void runFactorizer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number you want to factor: ");
        int inputNum = sc.nextInt();
        System.out.println("You enter " + inputNum);
        int sumOfFactors = 0;

        System.out.println("The factors of " + inputNum + " are: ");
        for (int i = 1; i < inputNum; i++) {
            if (inputNum % i == 0) {
                System.out.println(i);
                sumOfFactors = sumOfFactors + i;
            }
        }
        System.out.println(inputNum);

        if (sumOfFactors == inputNum) {
            System.out.println(inputNum + " is a perfect number");
        } else {
            System.out.println(inputNum + " is not a perfect number");
        }

        if (sumOfFactors == 1) {
            System.out.println(inputNum + " is a prime number");
        } else {
            System.out.println(inputNum + " is not a prime number");
        }

    }
    
}
