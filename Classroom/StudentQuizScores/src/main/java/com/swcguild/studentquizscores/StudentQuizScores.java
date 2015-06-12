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
        private List<Integer> scores = new ArrayList<>();

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

        public List<Integer> getScores() {
            return scores;
        }

        public double getAverage() {
            double sum = 0;
            for (Integer i : scores) {
                sum += i;
            }
            return sum / scores.size();
        }

    }

    public class UserInterFace {

        ConsoleIO io = new ConsoleIO();
        //ConsoleIO io2 = new ConsoleIO();
        
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
            ConsoleIO io2 = new ConsoleIO();
            String prompt = "Please enter student name:";
            String idPrompt = "Please enter a quiz score [0,100] (-1 to quit): ";
            String invalidPrompt = "Please enter a valid quiz score";
            //String name = "";
            String name = io2.getString(prompt);
           // System.out.println("addStudent: name:  " + name);
            List<Integer> scores = new ArrayList<>();
            int anID = 0;
            boolean done = false;
            do {
                anID = io2.getInteger(idPrompt);
                if (anID < -1 || anID > 100) {
                    System.out.println(invalidPrompt);

                } else if (anID == -1) {
                    done = true;
                } else {
                    scores.add(anID);
                }
            } while (!done);
            sList.put(anID, new Student(name, scores));
        }

        public void removeStudent() {
            String prompt = "Please enter student ID to be removed (-1 to quit): ";
            String invalidPrompt = "Please enter a valid student ID:  ";
            boolean done = false;
            do {
                int ID = io.getInteger(prompt);
                if (ID == -1) {
                    break;
                }
                Student x = sList.remove(ID);
                if (x == null) {
                    System.out.println("No student fournd with this ID");
                    //ID = io.getInteger(prompt);
                } else {
                    System.out.println("student removed: " + x.nameID());
                    done = true;
                }
            } while (!done);
        }

        public void viewQuizzes() {
            String prompt = "Please enter student ID to view scores (-1 to quit): ";
            String invalidPrompt = "Please enter a valid student ID:  ";
            boolean done = false;
            do {
                int ID = io.getInteger(prompt);
                if (ID == -1) {
                    break;
                }
                Student x = sList.get(ID);
                if (x == null) {
                    System.out.println("No student fournd with this ID");
                    //ID = io.getInteger(prompt);
                } else {
                    System.out.println(Arrays.toString(x.scores.toArray()));
                    done = true;
                }
            } while (!done);
        }

        public void viewStudentAverage() {
            String prompt = "Please enter student ID to view quiz average (-1 to quit): ";
            String invalidPrompt = "Please enter a valid student ID:  ";
            boolean done = false;
            do {
                int ID = io.getInteger(prompt);
                if (ID == -1) {
                    break;
                }
                Student x = sList.get(ID);
                if (x == null) {
                    System.out.println("No student fournd with this ID");
                    //ID = io.getInteger(prompt);
                } else {
                    System.out.println(Arrays.toString(x.scores.toArray()));
                    System.out.println(x.getAverage());
                    done = true;
                }
            } while (!done);
        }

        public void showMenu() {
            String prompt = "Please choose from the following: \n1) Add Student"
                    + "  2) Remove Student  3) View Student Scores  4) View Student Average  "
                    + "5) View Student List  6) Quit";
            String invalidPrompt = "Please enter a valid menu choice";
            boolean done = false;
            do {
                int choice = io.getInteger(prompt);
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        removeStudent();
                        break;
                    case 3:
                        viewQuizzes();
                        break;
                    case 4:
                        viewStudentAverage();
                        break;
                    case 5:
                        viewStudents();
                        break;
                    case 6:
                        done = true;
                        break;
                    default:
                        System.out.println(invalidPrompt);
                        break;
                }
            } while (!done);
        }
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
