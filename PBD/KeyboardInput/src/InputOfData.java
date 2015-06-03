
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
public class InputOfData {
 public static void main(String[]args){
         Scanner sc = new Scanner (System.in);
        
        String firstName;
        String lastName;
        int grade;
        int  studentID;
        

        int GPA;
   
System.out.println( "Your information: ");

System.out.println( "First Name: ");
    firstName = sc.nextLine();

System.out.println( "Last Name: ");
    lastName= sc.nextLine();


System.out.println("GPA:");  
  GPA = (int) sc.nextDouble();

System.out.println("Grade:" );
    grade = sc.nextInt();

System.out.println("studentID:" );
studentID= sc.nextInt();

   
String stringStudentID = Integer.toString(studentID);
   String loginName = lastName + stringStudentID;
System.out.println(loginName);
    }
}
        