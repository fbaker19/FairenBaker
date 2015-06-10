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
public class Chair {
//1. Define properties - determine which will be read/write and which will be read-only
//2. Implement setters and getters (as appropriate) for each property
//3. Implement a constructor to initialize some of all of the property values
//4. Determine what behaviors the class should have and then define (do not implement) the
//methods associated with each behavior.
    
    private String color;
    private int length;
    private int weight;
    private boolean cushions;
    private int cushionsNumbers;
    private static int numberOfChairs = 0;

  
    
    
    //Constructor 
    private Chair( int length, int weight, String color, boolean cushions, int cushionsNumber)
    
    {
        this.color = color;
        this.length= length;
        this.weight = weight;
        this.cushions = cushions;
        this.cushionsNumbers = cushionsNumbers;
        numberOfChairs++;
    }
    
    public static int getNumberOfTChairs() {
        return numberOfChairs;
    }

    public String getColor() {
        System.out.println("What colors would you like your chairs to be? ");
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
        System.out.println("How heavy do you want the chairs? ");
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isCushions() {
        System.out.println("Would you like for your chair to have cushions? ");
        return cushions;
    }

    public void setCushions(boolean cushions) {
        this.cushions = cushions;
    }

    public int getCushionsNumbers() {
        System.out.println("How many cushions would you like?");
        return cushionsNumbers;
    }

    public void setCushionsNumbers(int cushionsNumbers) {
        this.cushionsNumbers = cushionsNumbers;
    }

    public static int getNumberOfChairs() {
        return numberOfChairs;
    }

    public static void setNumberOfChairs(int numberOfChairs) {
        Chair.numberOfChairs = numberOfChairs;
    }
    
    
    public static void main(String[] args) {
      
       Chair reg = new Chair (20,25,"blue", true,2); 
      
        System.out.println("the chair's height is " + reg.length);
        System.out.println("the chair's weight is " + reg.weight);
        System.out.println("the chair's color is " + reg.color);
        System.out.println("the chair has cusions " +reg.cushions);
        System.out.println("the chair has "+reg.cushionsNumbers);
    }
    
    
}
    
    
    
    
    
    
    
    