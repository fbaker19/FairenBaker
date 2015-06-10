/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.classmodeling;

import javafx.scene.paint.Color;

/**
 *
 * @author apprentice
 */
public class Triangle {
//1. Define properties - determine which will be read/write and which will be read-only
//2. Implement setters and getters (as appropriate) for each property
//3. Implement a constructor to initialize some of all of the property values
//4. Determine what behaviors the class should have and then define (do not implement) the
//methods associated with each behavior.
    private static float height;
    private static float base;
    public static String color;
    private static float area;
    public static int numberOfTriangles = 0;

    
    //Constructor 
    public Triangle(float base, float height, String color) {//method signature/ parameters (they cannot match with other signatures)
        this.color = color;
        this.base = base;
        this.height = height;
        this.area = (float) (0.5 * (this.base * this.height));
        //this.area = calcArea(base,height);
        numberOfTriangles++;
    }

    public static float getHeight() {
        return height;
    }

    public static void setHeight(float height) {
        Triangle.height = height;
    }

    public static float getBase() {
        return base;
    }

    public static void setBase(float base) {
        Triangle.base = base;
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        Triangle.color = color;
    }

    public static float getArea() {
        return area;
    }

    public static void setArea(float area) {
        Triangle.area = area;
    }

    public static int getNumberOfTriangles() {
        return numberOfTriangles;
    }

    public static void setNumberOfTriangles(int numberOfTriangles) {
        Triangle.numberOfTriangles = numberOfTriangles;
    }
    
    public Triangle() { //method signature/ parameters 
        this.base = 5;
        this.height = 9;
        this.area = (float) (0.5 * (this.base * this.height));
        numberOfTriangles++;
    }
    
    public Triangle(float b, float h, float s) { //method signature/ parameters 
        
    }

    public float calcArea(float base, float height) //method > it's a calculation >> VERB
    {
        return (float) ((base * height) / 2);
    }

    public static void main(String[] args) {

        Triangle test1 = new Triangle(7,10,"green");
        Triangle test2 = new Triangle();
        System.out.println("the triangle's height is " + test1.height);
        System.out.println("the triangle's base is " + test1.base);
        System.out.println("the triangle's area is " + test1.area);
        System.out.println("the triangle's color is " + test1.color);

    }

}
