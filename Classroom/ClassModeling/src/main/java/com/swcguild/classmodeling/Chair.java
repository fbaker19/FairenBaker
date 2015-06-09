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
    
    private String color;
    private int length;
    private int weight;
    private static int numberOfChairs = 0;

  
    
    
    //Constructor 
    private Chair( int length, int weight, String color)
    
    {
        this.color = color;
        this.length= length;
        this.weight = weight;
        numberOfChairs++;
    }
    
    public static int getNumberOfTChairs() {
        return numberOfChairs;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public int getLength() {
        return length;
    }
    
    
    
    
    public static void main(String[] args) {
      
       Chair reg = new Chair (20,25,"blue"); 
      
        System.out.println("the chair's height is " + reg.length);
        System.out.println("the chair's weight is " + reg.weight);
        System.out.println("the chair's color is " + reg.color);

    }
    
    
}
    
    
    
    
    
    
    
    