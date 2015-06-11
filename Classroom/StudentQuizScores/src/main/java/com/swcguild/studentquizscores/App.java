/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.studentquizscores;

/**
 *
 * @author apprentice
 */
public class App {
    
    public static void main(String[] args) {
        StudentQuizScores grades = new StudentQuizScores();
        grades.getUi().viewStudentsAndScores();
        grades.getUi().addStudent();
        grades.getUi().viewStudentsAndScores();
        
    }
    
}
