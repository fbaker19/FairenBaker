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
public class Manager extends Employee{//a manager is also an employee
    
    
//    public Manager(String firstName)//contructor >>>> "public + class name(parameters)"
//    
//    {
//        super(1);///must be placed at the top, wwont run otherwise
//        this.firstName= firstName;
//        System.out.println("Manager constructor");
//    }

  
    
    public void doWork()
    {
        System.out.println("Get out of the way, I have manager things to do");
    }//override MUST be Exact, SAME EVERYTHING

    public void createObjectives()
    {
        System.out.println("MANAGER: Makes sure everyone else shows up on time and pays employees");
    }
    public void hire()
    {
    
    }
    public void fire()
    {
    
    }
    public void givePerformanceReviews()
    {
        
    }
    
    
    
    
}
