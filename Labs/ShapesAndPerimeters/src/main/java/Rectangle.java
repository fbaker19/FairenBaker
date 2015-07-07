/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Rectangle extends Shape {
    //area of rectangle:a = w*h
    //perpimeter: 2(w+h)   

    float width = con.readFloat("Please enter Rectangle height");
    float height = con.readFloat("Please enter Rectangle width");
    
    float area = width * height;
    float perimeter = 2 * (width * height);

    float ans = con.readFloat("The area is " + area + " and the  perimeter is " + perimeter);

//CONSTRUCTOR
    public Rectangle() {
        this.name = "Rectangle";

    }

    public float area() {

        return area;
    }

    public float perimeter() {

        return perimeter;
    }

}
