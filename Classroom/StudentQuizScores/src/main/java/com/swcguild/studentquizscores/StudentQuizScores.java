/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.studentquizscores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class StudentQuizScores {

    private Map<Integer, Student> sList;
    static int sIDGenerator = 42;
    private UserInterFace ui = new UserInterFace();

    public Map<Integer, Student> getsList() {
        return sList;
    }

    public UserInterFace getUi() {
        return ui;
    }

    public class Student {  // no '()' for class/object

        int studentID = 0;
        String studentName;
        List<Integer> scores = new ArrayList<>();

        //CONSTRUCTOR
        public Student(String name, List<Integer> scores) {
            this.studentID = sIDGenerator++;
            this.studentName = name;
            this.scores = scores;
        }

        public String toString() {
            //  System.out.println(studentName + "ID: " + studentID + "Scores: " + scores.toArray()); 
            return studentName + " ID: " + studentID + " Scores: " + Arrays.toString(scores.toArray());
        }

        public String nameID() {
            return studentName + " ID: " + studentID;
        }

    }

    public class UserInterFace {

        ConsoleIO io = new ConsoleIO();

        public void viewStudents() {
            for (Student s : sList.values()) {
                System.out.println(s.nameID());
            }
        }
        
        public void viewStudentsAndScores() {
            for (Student s : sList.values()) {
                System.out.println(s.toString());
            }
        }

        public void addStudent() {
            String prompt = "Please enter student name: ";
            String idPrompt = "Please enter a quiz score [0,100] (-1 to quit): ";
            String invalidPrompt = "Please enter a valid quiz score";
            String name = io.getString(prompt);
            List<Integer> scores = new ArrayList<>();
            int anID = 0;
            boolean done = false;
            do {
                anID = io.getInteger(idPrompt);
                if (anID < -1 || anID > 100) {
                    System.out.println(invalidPrompt);
                    continue;
//                    io.getInteger(idPrompt);
//                    scores.add(anID);
//                    sList.put(anID, new Student(name, scores));
//                    break;
                } else if (anID == -1) {
                   done=true;
                } else {

                    scores.add(anID);
               
                    //done = true;
                }
            } while (!done);
            sList.put(anID, new Student(name, scores));
        }
//        
//        public void addStudent() {
//            String prompt = "Please enter student name: ";
//            String idPrompt = "Please enter a quiz score [0,100] (-1 to quit): ";
//            String name = io.getString(prompt);
//            List<Integer> scores = new ArrayList<>();
//            int anID = 0;
//
//            do {
//                anID = io.getInteger(idPrompt);
//                if (anID > -1 && anID <= 100) {
//                    io.getInteger(idPrompt);
//                    scores.add(anID);
//                    sList.put(anID, new Student(name, scores));
//                    break;
//                } else if (anID == -1) {
//                    break;
//                } else {
//
//                }
//            } while (true);
//
//        }
    }

    public StudentQuizScores() {

        sList = new HashMap<>();
        List<Integer> scores = new ArrayList<>();
        scores.add(90);
        scores.add(80);
        scores.add(70);
        scores.add(90);
        Student first = new Student("Bobby", scores);

        List<Integer> scores2 = new ArrayList<>();
        scores2.add(100);
        scores2.add(85);
        scores2.add(77);
        scores2.add(88);
        Student second = new Student("Cindy", scores2);

        List<Integer> scores3 = new ArrayList<>();
        scores3.add(92);
        scores3.add(85);
        scores3.add(62);
        scores3.add(45);
        Student third = new Student("Todd", scores3);

        sList.put(first.studentID, first);
        sList.put(second.studentID, second);
        sList.put(third.studentID, third);

    }
}
