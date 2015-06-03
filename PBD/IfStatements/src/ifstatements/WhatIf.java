/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifstatements;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WhatIf {
    public static void main(String[] args){
    
        Scanner sc = new Scanner (System.in);
         int people = 20;
         int cats = 30; 
         int dogs = 10;
                 
   if(people < cats){
       System.out.println("The world is doomed!");
   
   }
    
   if(people > cats){
       System.out.println("The world is safe");
   
   }
    
   if(people < dogs){
       System.out.println("The world is drooled on!");
   }
    
   if(people > dogs){
       System.out.println("The world is Dry");
   
   }
    
   dogs+=5;
 
 
 if(people >= dogs){
     System.out.println("People are greater than or equal to dogs");
 }
   
 if(people <= dogs){
     System.out.println("People are less than or equal to dogs");
    }  
 
 if(people == dogs){
     System.out.println("People are dogs.");
 }
   
  
    
    }
    
}
