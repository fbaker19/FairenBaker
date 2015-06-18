/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.encodingdecoding;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class App {
    
    private static Map<Integer,Student> students = new HashMap<>();
    
    public static void main(String[] args) {//throws Exception {
        decode("Students.txt");
        Student student = new Student();
        student.setStudentID(3);
        student.setFirstName("Bob");
        student.setLastName("Sample");
        student.setCohort(".Net - August 2015");
        students.put(student.getStudentID(), student);
        encode("Students2.txt");
    }
    
    private static void encode(String fileName)
    {
        try{
    PrintWriter writer = new PrintWriter(new FileWriter(fileName));
    
    
    for(Integer key:students.keySet())
    {
     Student student = students.get(key);
     writer.printf("%d::%s::%s::%s", //%d formates numbers 001>> 1/ %d >> double
             student.getStudentID(),///%s === String
             student.getFirstName(),
             student.getLastName(),
             student.getCohort()      
        );  writer.println("");
   }
        writer.flush();
        writer.close();
        
        
        }catch(Exception e){
            System.out.println(e.getMessage());
       }
    
    }
    private static void decode(String fileName)
    {
        try{
    Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName))); 
       
        while(sc.hasNext())
        {
        String fileLine = sc.nextLine();
        String [] fileProperties = fileLine.split("::"); // reads between :: = array
           if(fileProperties.length == 4)                //[0001], [John],[Doe]
           {
               Student student = new Student();
               student.setStudentID(Integer.parseInt(fileProperties[0]));
               student.setFirstName(fileProperties[1]);
               student.setLastName(fileProperties[2]);
               student.setCohort(fileProperties[3]);
               students.put(student.getStudentID(),student);
           }                                             
        }
        
        }catch(Exception e)
        {
            System.out.println(e.getMessage()); //catch all
        
        }
    
    
    }
    
    
    
    
}
