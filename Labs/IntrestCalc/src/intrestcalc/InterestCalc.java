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
 
 double principal; //Principal
 double rate; //Rate
 double time; //Time
 
 //double interestTotal;
    

System.out.println("Please enter principal amount " );
        principal = sc.nextDouble();
        
System.out.println("Please enter the interest rate " );
        rate = sc.nextDouble();
System.out.println("Please enter the year " );
        time = sc.nextDouble();
       
        
   
       //double interestTotal = principal * Math.pow ((1+ rate/100),time);
        //add for loop yearly calc
        
        for(  time=0; time<=20; time++)
                     { 
            System.out.println(time);
            
                     
        double interestTotal = principal * Math.pow ((1+ rate/100),time);
         System.out.println("The compund interest is  " + interestTotal);
                     }
    
    }

 }