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

    private static float radius;
    private static float diameter;
    private static float circumference;
    
    private static int numberOfCircles = 0;

    public Circle(float radius ) 
    {
        this.radius = radius;
        this.diameter = calcDiameter(radius);
        this.circumference = calcCircumference(radius);
        numberOfCircles++;
    }

    private float calcDiameter(float radiusIn) 
    {
        return radiusIn * 2;
    }
    
    public float calcCircumference(float radiusIn) 
    {
        return (float) (2 * 3.14159 * radiusIn);
    }

   public void resize(float a) {
        this.radius += a;
        this.diameter = calcDiameter(this.radius);
        this.circumference = calcCircumference(this.radius);
    }

    public static void main(String[] args) {
        
        Circle big = new Circle(10);
        System.out.println("diameter 1 " + big.diameter);
        System.out.println("radius 1 " + big.radius);
        big.resize(-3);
        System.out.println("diameter 2 " + big.diameter);
        System.out.println("radius 2 " + big.radius);
    }

}
