/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplefileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIOSample {
    public static void main(String[] args) throws Exception
    //In Java, as you may know, exceptions can be categorized into two: One that needs the throws clause or must be handled if you don't specify one and another one that doesn't.
    //
    {
        
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        
        out.println("First line in my file....");
        out.println("second line in my file.....");
        out.println("a third line in my file...");
        out.flush();//send to a disk
        out.println("more words after the flush");
        out.flush();
        out.close();//close file/ cleans it/prevents resource leak
        
        Scanner sc = new Scanner(
            new BufferedReader(new FileReader("OutFile.txt")));
            
            while(sc.hasNextLine())
            {
                String currentLine = sc.nextLine();
                System.out.println("currentLine");
            
            
            }
        
        
    }
   
}
