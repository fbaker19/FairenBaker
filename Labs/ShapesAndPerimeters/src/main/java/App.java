
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
public class App {

    public static void main(String[] args) {

        ConsoleIO con = new ConsoleIO();

        Shape tri = new Triangle();
        tri.name = "Triangle";
        tri.setColor = "Yellow";

        tri.getArea();
        tri.getPerimeter();

        Shape sq = new Square();
        System.out.println("square");
        sq.setColor = "blue";

        sq.getArea();
        sq.getPerimeter();

        Shape rec = new Rectangle();
        System.out.println("rectangle");
        rec.setColor = "Green";

        rec.getArea();
        rec.getPerimeter();

        Shape circ = new Circle();
        System.out.println("circle");
        circ.setColor = "Red";

        circ.getArea();
        circ.getPerimeter();

    }
}
