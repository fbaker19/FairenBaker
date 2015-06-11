/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.schoolclasswarmup;

/**
 *
 * @author apprentice
 */
public class Classes {
    public static void main(String[] args) {
        
        Student Bobby = new Student("Bobby Johnson","BJohnson@SWCG.com",6);
        System.out.println("Hello, this is " +Bobby.getStudentName()+ " they can be reached at " +Bobby.getStudentEmail());
        System.out.println(Bobby.getStudentName() + " is taking "+ Bobby.get " classes this semester.");
        
        
    }
    
    
    
}
