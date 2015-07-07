
import com.swcguild.ConsoleIO;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
//Import Java.io.ConsoleIO;
public abstract class Shape {

    ConsoleIO con = new ConsoleIO();
    protected String color;
    protected String name;
   
    float area;
    float perimeter;
    String setColor;

  

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

   
    

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(float perimeter) {
        this.perimeter = perimeter;
    }

    //constructor
    public Shape() {

    }

    public float area()
    {
        return area;
    }

    public  float perimeter()
    {
       return perimeter;
    }

    
}
