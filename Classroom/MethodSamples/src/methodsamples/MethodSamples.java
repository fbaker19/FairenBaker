/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodsamples;

//import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class MethodSamples {

    public static void main(String[] args) { 
    //public -object
    //static - object
    //void - return type - returns nothing
    //main
        
       // Scanner sc = new Scanner(System.in);
        System.out.println("Hello World!");
        
        //String result = sc.nextLine();
        
        float testFloat= Float.parseFloat("42.7");
        //turns result and returns it in a float/decimal
         printHiYa();
        
         double Pi = calculatePi();
         
         System.out.println("pi:" + Pi);
         int value = add(3,5);
         
         System.out.println("3 plus 5 = " + value);
                     
    }
    
    
    public static void printHiYa(){
        System.out.println("HiYa");
    } 
        
     public static double calculatePi()
     {
            return 3.141592;
        }
    
     public static int add1And1()
     {
         return 1+1;
     }
     
     public static int add1And2(){
         return 1+2;
     }
     public static int add1And3(){
         return 1+3;
     }
     
     //functions below - pass perimeters in
     
     public static int add(int a, int b)
     {
         return a+b;
     }
}




