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
public class InterestCalcRefactored {
    {
        Scanner sc = new Scanner(System.in);

        //Initial amount of principal:
        double originalBalance;
        double currentBalance;

        //The number of years the money is to stay in the fund:
        double numYears;

        double numPeriods;

        //Annual interest rate:
        double intRate;

        double annualInterest;

        //Year end new balance:
        double newBalance;

        System.out.println("What amount will you deposit in the fund?");
        originalBalance = sc.nextDouble();

        System.out.println("What annual interest rate did you qualify for?");
        intRate = sc.nextDouble();

        System.out.println("How many years will the principal and interest stay in the fund?");
        numYears = sc.nextDouble();

        System.out.println("How many times per year will the interest be compounded?");
        numPeriods = sc.nextDouble();

        int yearCount = 0;

        do {

            newBalance = originalBalance * (Math.pow(1 + ((intRate * .01) / numPeriods), (numPeriods)));

            annualInterest = newBalance - originalBalance;

            yearCount++;
            System.out.println("Year " + yearCount);
            System.out.printf(" - Principal at start of year: $%.2f", originalBalance);
            System.out.printf(" - Interest earned this year: $%.2f", annualInterest);
            System.out.printf(" - Principal at end of year: $%.2f", newBalance);
            System.out.println("\n");

            originalBalance = newBalance;
        } while (yearCount <= (numYears - 1));

    }
    
}
