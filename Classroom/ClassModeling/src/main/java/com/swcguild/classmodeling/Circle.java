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
public class Circle {
//1. Define properties - determine which will be read/write and which will be read-only
//2. Implement setters and getters (as appropriate) for each property
//3. Implement a constructor to initialize some of all of the property values
//4. Determine what behaviors the class should have and then define (do not implement) the
//methods associated with each behavior.

    private static float radius;
    private static float diameter;
    private static float circumference;
    private static String color;
    private static boolean filled;
    
    private static int numberOfCircles = 0;

    public Circle(float radius, String color, boolean filled ) 
    {
        this.radius = radius;
        this.diameter = calcDiameter(radius);
        this.circumference = calcCircumference(radius);
        this.color = color;
        this.filled = filled;
        numberOfCircles++;
    }

    public static float getRadius() {
        System.out.println("Enter a radius "+radius);
        return radius;
    }

    public static void setRadius(float radius) {
        Circle.radius = radius;
    }

    public static float getDiameter() {
        System.out.println("Based on the radius, the diameter is "+diameter);
        return diameter;
    }

    public static void setDiameter(float diameter) {  
        Circle.diameter = diameter;
    }

    public static float getCircumference() {
        System.out.println("Based on the radius, the dcircumference is "+circumference);
        return circumference;
    }

    public static void setCircumference(float circumference) {
        Circle.circumference = circumference;
    }

    public static String getColor() {
        System.out.println("Enter a color for the circle " +color);
        return color;
    }

    public static void setColor(String color) {
        Circle.color = color;
    }

    public static boolean isFilled() {
        return filled;
    }

    public static void setFilled(boolean filled) {
        Circle.filled = filled;
    }

    public static int getNumberOfCircles() {
        System.out.println("There are "+ numberOfCircles+" of circles");
        return numberOfCircles;
    }

    public static void setNumberOfCircles(int numberOfCircles) {
        Circle.numberOfCircles = numberOfCircles;
    }
    
    
    
    
    
    
    private float calcDiameter(float radiusIn) //method (often shows action, verb)
    {
        return radiusIn * 2;
    }
    
    public float calcCircumference(float radiusIn) //method (often shows action, verb)
    {
        return (float) (2 * 3.14159 * radiusIn);
    }

   public void resize(float a) {
        this.radius += a;
        this.diameter = calcDiameter(this.radius);
        this.circumference = calcCircumference(this.radius);
    }

    public static void main(String[] args) {
        
        Circle big = new Circle(10,"purple",true);
        System.out.println("The color of the circle is "+ big.color);
        System.out.println("The cirlce is " + big.filled);
        System.out.println("diameter 1 " + big.diameter);
        System.out.println("radius 1 " + big.radius);
        big.resize(-3);
        System.out.println("diameter 2 " + big.diameter);
        System.out.println("radius 2 " + big.radius);
    }

}
