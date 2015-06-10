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
//1. Define properties - determine which will be read/write and which will be read-only
//2. Implement setters and getters (as appropriate) for each property
//3. Implement a constructor to initialize some of all of the property values
//4. Determine what behaviors the class should have and then define (do not implement) the
//methods associated with each behavior.
        
    private String color;
    private int length;
    private int weight;
    private static int numberOfCouches = 0;
    private static boolean cushions;
    private int cushionNumber;

    
    //Constructor 
    private Couch( int length, int weight, boolean cushions, String color, int cushionNumber)
    
    {
        this.color = color;
        this.length= length;
        this.weight = weight;
        this.cushions = cushions;
        this.cushionNumber = cushionNumber;
        numberOfCouches++;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static int getNumberOfCouches() {
        return numberOfCouches;
    }

    public static void setNumberOfCouches(int numberOfCouches) {
        Couch.numberOfCouches = numberOfCouches;
    }

    public static boolean isCushions() {
        return cushions;
    }

    public static void setCushions(boolean cushions) {
        Couch.cushions = cushions;
    }

    public int getCushionNumber() {
        return cushionNumber;
    }

    public void setCushionNumber(int cushionNumber) {
        this.cushionNumber = cushionNumber;
    }
    
    
   
 
    public static void main(String[] args) {
      
       Couch fluffy = new Couch (20,25,true,"red",3); //method signature must match beginninig of constructor
                                                    //4 variables in constructor ---> 4 variables in Met Sig
        System.out.println("the couch's height is " + fluffy.length);
        System.out.println("the couch's weight is " + fluffy.weight);
        System.out.println("the couch has cushions " + fluffy.cushions);
        System.out.println("the couch's color is " + fluffy.color);
        System.out.println("the couch has "+fluffy.cushionNumber+ " of cushions");
    }
    
    
}
