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
public abstract class Employee {
    
    protected String firstName;//private can not be acessed in the super(everything) class
                             //only acces by base(employee)   
    protected String lastName; //protected allows other classes to uses as long as they are extended
    
//    public Employee(String firstName)//constructor
//    {
//        this.firstName=firstName;
//        System.out.println("Employee constructor");
//    
//    }
//    
//    public Employee(Integer EmployeeNum)
//    {
//        System.out.println("Employee number constructor");
//    }
    public void doWork()
    {
        System.out.println("Employee did work");
    }
    
    public abstract void createObjectives();
//    {
//        System.out.println("Employee:Come in on time, and get all their work done");
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public  void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    protected void readPerformanceReview()
    {
    
        System.out.println("good job!");
    }
    
    
}
