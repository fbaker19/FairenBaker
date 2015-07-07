/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Triangle extends Shape {

    
    float base = con.readFloat("Please enter the base of the triangle");
    float height = con.readFloat("Please enter triangle height");
    float sideA = con.readFloat("Please enter  Side 'a'");
    float sideC = con.readFloat("please enter side 'c'");
    
    float area = (float) (0.5 *(base * height));
    float perimeter =  sideA + base + sideC;
    
     float ans = con.readFloat("The area is " + area + " and the  perimeter is " + perimeter);

    //Constructor
    public Triangle() {
        this.name = "Triangle";

    }

    public float area() {
      
    //area of triangle:0.5*base*hght 

        return area;
    }

    public float perimeter() {
      //perimeter: SideA + base + SideC

        return perimeter;
    }

}
