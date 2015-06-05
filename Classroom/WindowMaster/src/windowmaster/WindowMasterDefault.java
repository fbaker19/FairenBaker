/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package windowmaster;
import java.util.Scanner;
/**
*
* @author ilyagotfryd
*/
public class WindowMasterDefault {
public static void main(String[] args) {

    float height;
float width;

String stringHeight;
String stringWidth;

float areaOfWindow;

double cost;

float perimeterOfWindow;

Scanner sc = new Scanner(System.in);

// System.out.println("Please enter window height:");
// stringHeight = sc.nextLine();
// height = Float.parseFloat(stringHeight);

        //height = readUserInputFloat("Please enter window height:");

// System.out.println("Please enter window width:");
// stringWidth = sc.nextLine();
// width =Float.parseFloat(stringWidth);

            //width = readUserInputFloat("Please enter window width:");

height = readUserFloatRange("Please enter window height:" , 1,15);
        
width = readUserFloatRange("Please enter window width:",1,15);
 

areaOfWindow = height * width;

perimeterOfWindow = 2*(height + width);

cost = ((3.50f * areaOfWindow)+(2.25f*perimeterOfWindow));

System.out.println("Window height = " + height);//stringHeight);
System.out.println("Window width = " + width);
System.out.println("Window area = " + areaOfWindow);
System.out.println("Window perimeter = " + perimeterOfWindow);
System.out.printf("Total Cost = %.2f\n", cost);

}

public static float readUserInputFloat(String prompt)
{
Scanner sc = new Scanner(System.in);
System.out.println(prompt);

String stringInput = sc.nextLine();

float result = Float.parseFloat(stringInput);
return result;
}

//  public static int MaxMin(String prompt, int min, int max) {
//      Scanner sc = new Scanner(System.in);
//      System.out.println(prompt);
//      
//      String stringInput = sc.nextLine();
//  
//      while(!(min>=1 || max<=15)){ 
//          ;
//    System.out.println("Please enter valid number between 1 & 15");
//      stringInput = sc.nextLine();
//  }
//       stringInput = sc.nextLine();
// int result =  Integer.parseInt(stringInput);
//  return result;
//          }
  
  
  //EXAMPLE CORRECT
  
  public static float readUserFloatRange(String prompt, float min, float max){
      
      Scanner sc= new Scanner(System.in); //1. import scanner
      
      float result = 0;
      do{
          
      System.out.println(prompt); // 2. set up the prompt
      
      String stringInput = sc.nextLine(); //3. set up user response
      
       result = Float.parseFloat(stringInput);//4. result is now the user's response variable
      
  }while(result <min || result > max);// user result range
      return result;
  
  }
  
  
  
  
      }