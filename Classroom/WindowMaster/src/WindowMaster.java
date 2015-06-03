
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class WindowMaster {
    public static void main(String[]args){
     Scanner sc= new Scanner (System.in);   
        
        float height;
        float width;
        float enterCost;
        
    String height2;
    String width2;
    
    float area;
    double cost;
    float perimeter;
    
    
  //do while start
        System.out.println("Enter window height");
            height2 = sc.nextLine();
        
        System.out.println("Enter window width");
            width2 = sc.nextLine();
    
 
            height =Float.parseFloat(height2);
            width = Float.parseFloat(width2);
            
            area = height * width;
            perimeter = 2*( height + width);
            
           //do while end   
            cost = ((3.50f * area)+ (2.25f * perimeter));
    
    System.out.println("Window height = "+ height2);
    System.out.println("Window width = " + width2);
    System.out.println("Window area = "+ area);
    System.out.println("Window perimeter = " + perimeter);
    System.out.printf("Total cost = %.2f\n", cost);
    
    System.out.print("Please enter  cost you are willing to pay ");
        enterCost = sc.nextFloat();
   
    
    }
    
}
