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

    private Couch( int length, int weight, boolean cushions, String color)
    
    {
        this.color = color;
        this.length= length;
        this.weight = weight;
        this.cushions = cushions;
        numberOfCouches++;
    }
    
    public static int getNumberOfTCouches() {
        return numberOfCouches;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public int getLength() {
        return length;
    }
    
 
    public static void main(String[] args) {
      
       Couch fluffy = new Couch (20,25,true,"red"); 
      
        System.out.println("the couch's height is " + fluffy.length);
        System.out.println("the couch's weight is " + fluffy.weight);
        System.out.println("the couch has cushions " + fluffy.cushions);
        System.out.println("the couch's color is " + fluffy.color);

    }
    
    
}
