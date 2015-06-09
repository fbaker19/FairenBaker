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
public class Table {
    
    
    private String color;
    private int length;
    private int weight;
    private static int numberOfTables = 0;
    
    //Constructor 
    public Table( int length, int weight, String color){
        this.color = color;
        this.length= length;
        this.weight = weight;
        numberOfTables++;
    }
    
    public static int getNumberOfTables() {
        return numberOfTables;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public int getLength() {
        return length;
    }
    
    
    
    
    public static void main(String[] args) {
      
        Table furniture = new Table(20,25,"blue"); 
      
        System.out.println("the table's height is " + furniture.length);
        System.out.println("the table's weight is " + furniture.weight);
        System.out.println("the table's color is " + furniture.color);

    }
    
}
