/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Square extends Shape {
   

    float side = con.readFloat("please enter is number to calculate\n "
            +"the area and perimerter of a square ");
    float area = (float) Math.pow(side, 2);
    float perimeter = side * 4;
    
    float ans = con.readFloat("The area is " + area + " and the  perimeter is " + perimeter);
    
    public Square()
    {
    
    this.name = "Square";
    }

    public float area() {
        //area of square: a^2 
        return area;
    }

    public float perimeter() {
         //perimeter:(side*4)
        return perimeter;
    }

}
