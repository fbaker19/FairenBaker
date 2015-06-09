/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.classmodeling;

/**
 *
 * @author apprentice
 */
public class Couch {
        
    private String color;
    private int length;
    private int weight;
    private static int numberOfCouches = 0;
    private static boolean cushions;

    
    //Constructor 
    private Couch( int length, int weight, boolean cushions, String color)
    
    {
        this.color = color;
        this.length= length;
        this.weight = weight;
        this.cushions = cushions;
        numberOfCouches++;
    }
    
    public static int getNumberOfTCouches() { //public often needs return
        return numberOfCouches;
    }
    
    public int getWeight() { //public often needs return
        return weight;
    }
    
    public int getLength() { //public often needs return
        return length;
    }
    
 
    public static void main(String[] args) {
      
       Couch fluffy = new Couch (20,25,true,"red"); //method signature must match beginninig of constructor
                                                    //4 variables in constructor ---> 4 variables in Met Sig
        System.out.println("the couch's height is " + fluffy.length);
        System.out.println("the couch's weight is " + fluffy.weight);
        System.out.println("the couch has cushions " + fluffy.cushions);
        System.out.println("the couch's color is " + fluffy.color);

    }
    
    
}
