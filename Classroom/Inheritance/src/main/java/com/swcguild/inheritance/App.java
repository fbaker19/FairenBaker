/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.inheritance;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        
//        Employee employee = new Employee();
//                employee.setFirstName("Josh");
//                
//                Manager manager = new Manager();
//                
//                manager.setFirstName("Mitch");
//                
//                SummerIntern intern = new SummerIntern();
//                
//                intern.createObjectives();
//                
//                manager.readPerformanceReview();
        
     //  Manager manager = new Manager();// pass it a string ie "bob"
         //Manager manager = new Manager("bob");
         
        // Employee employee = new Manager("abba");// sets manager to regular employee
     
    //Polymorphism     
   Employee employee = new Manager();
   employee.createObjectives();
   
   Employee summerIntern = new SummerIntern();
   summerIntern.createObjectives();
   //polymorphism
   
   
    }
    
}
