/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Circle extends Shape {

   
  
    float radius = con.readFloat("please enter a radius");
    
    float perimeter = (float) (2 * Math.PI * radius);
    float area = (float) (Math.PI * (Math.pow(radius, 2)));

    float ans = con.readFloat("The area is " + area + " and the  perimeter is " + perimeter);

    //construtor
    public Circle() {
        this.name = "Circle";
    }

    public float perimeter() {
  //perimeter:2*pi*r
        return perimeter;
    }

    public float area() {
 //area of circle: A= PI*r^2 (r=radius >> 1/2 diameter)
        return area;
    }

}
