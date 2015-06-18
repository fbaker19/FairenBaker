/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.schoolclasswarmup;

import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class Student {
HashMap<String, Integer> classes = new HashMap<>();
    //Map<String class>classMap; -ilya
    //Map<String student>studentMap; -ilya
    private String studentName;
    private String studentEmail;
    //private int classes;
    private int numberOfClasses = 0;
    //HashMap<String, Integer> classes; //HashMap<String,Class>

//Contstructor/ "this." statements
    public Student(String studentName, String studentEmail, int NumberOfClasses) {

        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.classes = classes;
        numberOfClasses++;
    }

    public void Class() {
        
    
        classes.put("Bobby Johnson", 6);
        classes.put("Freddie Jupiter", 4);
        classes.put("Joan Airbus", 8);
        classes.put("Kurt Cobalt", 3);
        classes.put("Tupp Ahck", 5);
    
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

//    public int getClasses() {
//        return classes;
//    }

//    public void setClasses(int classes) {
//        this.classes = classes;
//    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    
    
    //public void addStudent(Student student)
        //call add class on  a given student
        
        
//        public void removeStudent()
//        {
//            //call remove class on given student
//        }
    }
    
    

}
