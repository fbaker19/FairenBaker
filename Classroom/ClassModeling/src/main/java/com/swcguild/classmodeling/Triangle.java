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
    public static int getNumberOfTriangles() {
        return numberOfTriangles;
    }
    
    public float getBase() {
        return base;
    }
    
    public float getHeight() {
        return height;
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
