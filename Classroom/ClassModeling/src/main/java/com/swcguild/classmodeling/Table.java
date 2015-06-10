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
    
//1. Define properties - determine which will be read/write and which will be read-only


//4. Determine what behaviors the class should have and then define (do not implement) the
//methods associated with each behavior.
    private String color;
    private float length;
    private float weight;
    private float height;
    private String shape;
    public static int numberOfTables = 0;
    
    //Constructor 
    public Table( float length, float weight, float height, String color, String shape){
        this.color = color;
        this.length= length;
        this.weight = weight;
        this.height = height;
        this.shape = shape;
        numberOfTables++;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getShape() {
        System.out.println("What shape would you like your new table? " +shape);
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public static int getNumberOfTables() {
       
        System.out.println("There are " +numberOfTables);
        return  numberOfTables;
    
    }
    
   
    

    public static void setNumberOfTables(int numberOfTables) {
        Table.numberOfTables = numberOfTables;
    }
    
  
    
    public static void main(String[] args) {
        
      
        Table furniture = new Table(5,20, (float) 3.5,"blue","round"); 
      
        System.out.println("the table's length is " + furniture.length+ " ft");
        System.out.println("the table's weight is " + furniture.weight+ " lbs");
        System.out.println("the table's height is " +furniture.height+ " ft");
        System.out.println("the table's color is " + furniture.color);
        System.out.println("the table's shape is " + furniture.shape);

    }
    
}
