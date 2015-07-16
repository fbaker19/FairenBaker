/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floorcalc;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FloorCalc {
    public static void main(String[] args) {
        
    
    float width;
    float length;
    
    float SqFtPerQt = 5;//sqft==area
    float costPerQt = (float) 21.5;
  //every 15 min - they put down  5 sqft
    //5sqft = 21.50 per 15min
    
    
    //costPerHr*time?? - no
    //cost is determined by sqft & costperhour+billing
  

    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter the length of room: ");
    length = sc.nextFloat();

  
    System.out.print("Enter the width of room: ");
     width = sc.nextFloat();
     
    float area = (length*width);
    System.out.println(area);
    
    System.out.println("Your area is: "+area);
//   
//    if(area <=4)
//    {
//        System.out.println( Math.round(area));
//    }else{
//        System.out.println( Math.ceil(area));
//    }
 
    
    float newArea = (float) (5*(Math.ceil(Math.abs(area/5))));///rounds to nearest whole number then * by 5
        System.out.println ("at new area: " + newArea);  
    
        
    float totalCost = (newArea*costPerQt)/5;///divideds cost by quarter
    
        System.out.println("total cost is: "+totalCost);
         
    }
}
 // increments of 20 
// if  sqft is  greater thatn 20 but lesthan 40  cost per hr * 2

/*
    20 sqft is the max per hr, hr = $86 
billing is done in increments of 15 min/ quarters
$86 /4 = $21.50

must round to nearest increment of 5

if (user input/area  is between 1 &4 - math.floor)
else {
    math.ceil


}

user input is rounded and multiplied by $21.50 to get total cost

totalcost = userinput/area* $21.50

*/