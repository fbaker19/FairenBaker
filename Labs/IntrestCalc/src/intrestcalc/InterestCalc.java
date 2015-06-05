/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intrestcalc;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class InterestCalc {
    public static void main(String[] args){
 
   Scanner sc = new Scanner(System.in);     
//CurrentBalance * (1 + (QuarterlyInterestRate / 100)
 //500 (1 +(.1/4)^80 ---> 500(1+ .1 percent/4 = amount of times intrest added) ^ n= number t=time
 
 double P; //Principal
 double R; //Rate
 double T; //Time
 
 //double interestTotal;
    

System.out.println("Please enter principal amount " );
        P = sc.nextDouble();
        
System.out.println("Please enter the interest rate " );
        R = sc.nextDouble();
System.out.println("Please enter the year " );
        T = sc.nextDouble();
       
        
        double interestTotal = P * Math.pow ((1+ R/100),T);
        
        
        System.out.println("The compund interest is  " + interestTotal);
        
    }

 }