/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.fileinputoutput;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class HighScore {

    public static void main(String[] args) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter("score.txt");
        Scanner sc = new Scanner(System.in);

        int score;
        String name;

        System.out.println("Please enter your name");
        name = sc.nextLine();

        System.out.println("Please enter your score");
        score = sc.nextInt();

        System.out.println("Hi " + name + ", your score is " + score);

        System.out.println("Data stored into score.txt.");

        writer.close();

    }
}
