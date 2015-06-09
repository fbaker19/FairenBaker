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
 
 double principal = 500; //Principal
 double rate = 10; //Rate
 double time = 20; //Time
 
 //double interestTotal;
    

System.out.println("John's principal amount is " + principal );
        
        
System.out.println("John's rate is " + rate );
        
System.out.println("John's time period for collecting interest is" +time );
       
       
        
       //double interestTotal = principal * Math.pow ((1+ rate/100),time);
        //add for loop yearly calc
        
        for(  time=0; time<=20; time++)
                     { 
            System.out.println(time);
            
                     
        double interestTotal = principal * Math.pow ((1+ rate/100),time);
         System.out.println("John's compund interest is  " + interestTotal);
                     }
        
        
        
        double quarterlyRate = .025;
        
        
System.out.println("John's principal amount " + principal );
        
        
System.out.println("John's quarterly interest rate is " + quarterlyRate );
        
System.out.println("John's time period for collecting interest is " +time);
       
       for(  time=0; time<=20; time++)
                     { 
            System.out.println(time);
            
                     
        double interestTotal = principal * Math.pow ((1+ quarterlyRate/100),time);
         System.out.println("John's quartely compund interest is  " + interestTotal);
                     }
       
       
       
       
          double monthlyRate = .0084;
        
        
        
System.out.println("John's principal amount "+ principal );
            
System.out.println("John's monthly interest rate is " + monthlyRate );
        
System.out.println("John's time period for collecting interest is " +time);
        
       for(  time=0; time<=20; time++)
                     { 
            System.out.println(time);
            
                     
        double interestTotal = principal * Math.pow ((1+ monthlyRate/100),time);
         System.out.println("John's monthly compund interest is  " + interestTotal);
                     }
     
                     
        
                     
                     double dailyRate = .00028;
        
        
System.out.println("John's principal amount "+ principal );
        
        
System.out.println("John's daily interest rate is " + dailyRate );
        
System.out.println("John's time period for collecting interest is " +time);
        

       for(  time=0; time<=20; time++)
                     { 
            System.out.println(time);
            
                     
        double interestTotal = principal * Math.pow ((1+ dailyRate/100),time);
         System.out.println("John's daily compund interest is  " + interestTotal);
                     }
    
    
    
    
    }

 }