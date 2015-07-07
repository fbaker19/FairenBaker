/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.dao;

import com.swcguild.dvdlibrary.dto.Library;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.lang.ArrayIndexOutOfBoundsException;
/*1. import file, delimiter, & HashMap w/ imported DTO class
 2. instantiate a "load" method ie loadLibrary 
 -Import: Scanner sc = new Scanner(new BufferedReader(new FileReader(FILENAME_FILE)));
 -"thrown exception will be imported
 3. After working on switch case in contoller, create a while loop for the setter variables
 in while: import DTO ->  DTO currentDTO = new DTO(currentTokens[0]); 
 - currentTokens ---> ARRAY
 4. instantiate the "write" method ie writeLibrary
 - this is what actually writes and saves to a file
 4b. import PrintWriter ie -PrintWriter out = new PrintWriter(new FileWriter(FILENAME_FILE)
 - and throw exception(automatic)
   
 5.  (writeLibrary) add for loop for array length ie or (int i = 0; i < keys.length; i++)
 -the for loop: import out.println (currentDTO.getVariables +  DELIMITER);
 -ie  out.println(currentLibrary.getTitle() + DELIMITER + currentLibrary.getDirector() + DELIMITER
 -5b. flush = out.flush(); & close file = out.close();

 */
public class DVDLibrary {

    public static final String DVDLIBRARY1_FILE = "DVDLibrary1.txt";//1 import file & Delimiter
    public static final String DELIMITER = "::"; //Delimiter = ::

    private HashMap<String, Library> libraries = new HashMap<String, Library>();//2/ import DTO Class

    public void loadLibrary() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(DVDLIBRARY1_FILE)));//Import Scanner (BufferedReader(FileReader(FILENAME_FILE)));
        String currentLine;
        String[] currentTokens;//ARRRAY LIST
        // work on controller after steps completed above

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);// array

            Library currentLibrary = new Library(currentTokens[0]);
          //imports DTO class &creates new constructor in DTO -- change into constructor >> this."___" 

            //setters - currentDTO.set
           // currentLibrary.setTitle(currentTokens[0]);//needed?
           
            currentLibrary.setDirector(currentTokens[1]);
            currentLibrary.setYear(Integer.parseInt(currentTokens[2]));
            currentLibrary.setMpaa(currentTokens[3]);
            currentLibrary.setRating(Float.parseFloat(currentTokens[4]));//user rating
            currentLibrary.setStudio(currentTokens[5]);

            libraries.put(currentLibrary.getTitle(), currentLibrary);//what to search by
        }
        sc.close();
    }

    

    public void writeLibrary() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(DVDLIBRARY1_FILE));
        String[] keys = this.getAllTitles();//creates 'get' method w/in DAO(this class)

        for (int i = 0; i < keys.length; i++) {
           
            Library currentLibrary = this.getLibrary(keys[i]);//creates 'get' method(see methods below)

            out.println(currentLibrary.getTitle() + DELIMITER
                    + currentLibrary.getDirector() + DELIMITER
                    + currentLibrary.getYear() + DELIMITER
                    + currentLibrary.getMpaa() + DELIMITER
                    + currentLibrary.getRating() + DELIMITER
                    + currentLibrary.getStudio());

            out.flush();
        }
        out.close();
    }

    public String[] getAllTitles() {
        Set<String> keySet = libraries.keySet();//sets array size
        String[] keyArray = new String[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }
public void addTitle(String title, Library library) {
        libraries.put(title, library);

    }
    public Library getLibrary(String title) {
        return libraries.get(title);
    }

    public Library removeTitle(String title) {

        return libraries.remove(title);

    }
}
