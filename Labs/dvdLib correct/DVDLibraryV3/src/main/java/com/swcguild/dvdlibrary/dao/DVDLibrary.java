/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.dao;

import com.swcguild.dvdlibrary.dto.DVD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DVDLibrary implements DvdLibraryDao {///DVDLibraryInterface

    public static final String DVDLIB_FILE = "dvdlib.txt";
    public static final String DELIMITER = "::";
    public HashMap<String, DVD> allDVDs = new HashMap<String, DVD>();
    public List<DVD> dvd = new ArrayList<>();
   
    public void loadDVDLibrary() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(DVDLIB_FILE)));
        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            DVD currentDVD = new DVD(currentTokens[0]);

            currentDVD.setName(currentTokens[0]);
            currentDVD.setDate(currentTokens[1]);
            currentDVD.setRating(currentTokens[2]);
            currentDVD.setDirector(currentTokens[3]);
            currentDVD.setStudio(currentTokens[4]);
            String[] currentNotes = currentTokens[currentTokens.length - 1].split("\\|\\|");
            ArrayList<String> otherNotes = new ArrayList();
            for (String x : currentNotes) {
                otherNotes.add(x);
            }
            currentDVD.setNotes(otherNotes);

            allDVDs.put(currentDVD.getName(), currentDVD);
        }
        sc.close();
    }

    public void addDVD(String name, DVD currentDVD) {
        allDVDs.put(name, currentDVD);
    }

    public void writeDVDs() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(DVDLIB_FILE));
        String[] keys = this.getAllDVDs();
        for (int i = 0; i < keys.length; i++) {
            DVD currentDVD = this.getDVD(keys[i]);
            out.print(currentDVD.getName() + DELIMITER
                    + currentDVD.getDate() + DELIMITER
                    + currentDVD.getRating() + DELIMITER
                    + currentDVD.getDirector() + DELIMITER
                    + currentDVD.getStudio() + DELIMITER);

            String printNotes = "";
            if (currentDVD.getNotes() != null) {
                for (String s : currentDVD.getNotes()) {
                    printNotes += s + "||";
                }
                out.println(printNotes);
            }
            out.flush();
        }
        out.close();
    }

   

    public DVD getDVD(String name) {
        return allDVDs.get(name);
    }

    @Override
    public void removeDVD(String name) {
        allDVDs.remove(name);
    }

    @Override
    public DVD searchByName(String name) {
        return allDVDs.get(name);
    }

    @Override
    public List<DVD> searchByDate(String date) {
        List<DVD> dvds
                = allDVDs.values()
                .stream()
                .filter(s -> s.getDate().equalsIgnoreCase(date))
                .collect(Collectors.toList());
        return dvds;
    }

    @Override
    public List<DVD> searchByRating(String rating) {
        List<DVD> dvds
                = allDVDs.values()
                .stream()
                .filter(s -> s.getRating().equalsIgnoreCase(rating))
                .collect(Collectors.toList());

        return dvds;
    }

    @Override
    public Map<String, List<DVD>> searchByDirector(String director) {
        Map<String, List<DVD>> dvds
                = allDVDs.values()
                .stream()
                .filter(s -> s.getDirector().equalsIgnoreCase(director))
                .collect(Collectors.groupingBy(DVD::getRating));

        return dvds;
    }

    @Override
    public List<DVD> searchByStudio(String studio) {
        List<DVD> dvds
                = allDVDs.values()
                .stream()
                .filter(s -> s.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());

        return dvds;
    }

    @Override
    public void getAvgAge() {
//        double averageAge;
//        averageAge = allDVDs.values()
//                .stream()
//                .mapToString(DVD::getDate)
//                //.mapToLong(s->s.getServerAge())
//                .average()
//                .getAsDouble();
//        double realAvgAge = 2015 - averageAge;

    }

//    @Override
//    public void removeDVD(String name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void add(DVD dvd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> listAll() {
          List<DVD> dvd = new ArrayList<>(allDVDs.values());///constuctor of Array List<>()
        return dvd;
             
    }

    @Override
    public DVD getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getByTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getByRating(String rating) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getByStudio(String studio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addDVD(String name, Dvd currentDVD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
