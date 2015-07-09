/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryv3.dao;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
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
public class DVDLibraryImpl implements DvdLibraryDao {

    public static final String DVDLIB_FILE = "dvdlib.txt";
    public static final String DELIMITER = "::";
    public HashMap<String, DVD> allDvds = new HashMap<String, DVD>();

    
//    public void loadDVDLibrary() throws FileNotFoundException {
//        Scanner sc = new Scanner(new BufferedReader(new FileReader(DVDLIB_FILE)));
//        String currentLine;
//        String[] currentTokens;
//
//        while (sc.hasNextLine()) {
//            currentLine = sc.nextLine();
//            currentTokens = currentLine.split(DELIMITER);
//
//            DVD currentDVD = new DVD(currentTokens[0]);
//
//            currentDVD.setName(currentTokens[0]);
//            currentDVD.setDate(currentTokens[1]);
//            currentDVD.setRating(currentTokens[2]);
//            currentDVD.setDirector(currentTokens[3]);
//            currentDVD.setStudio(currentTokens[4]);
//            String[] currentNotes = currentTokens[currentTokens.length-1].split("\\|\\|");
//            ArrayList<String> otherNotes = new ArrayList();
//            for (String x : currentNotes) {
//                otherNotes.add(x);
//            }
//            currentDVD.setNotes(otherNotes);
//
//            allDVDs.put(currentDVD.getName(), currentDVD);
//        }
//        sc.close();
//    }

    public void addDVD(String name, DVD currentDVD) {
        allDvds.put(name, currentDVD);
    }

//    public void writeDVDs() throws IOException {
//        PrintWriter out = new PrintWriter(new FileWriter(DVDLIB_FILE));
//        String[] keys = this.getAllDVDs();
//        for (int i = 0; i < keys.length; i++) {
//            DVD currentDVD = this.searchByName(keys[i]);
//            out.print(currentDVD.getName() + DELIMITER
//                    + currentDVD.getDate() + DELIMITER
//                    + currentDVD.getRating() + DELIMITER
//                    + currentDVD.getDirector() + DELIMITER
//                    + currentDVD.getStudio() + DELIMITER);
//            
//            String printNotes = "";
//            if (currentDVD.getNotes() != null) {
//            for (String s : currentDVD.getNotes()) {
//                printNotes += s + "||";
//            }
//            out.println(printNotes);
//            }
//            out.flush();
//        }
//        out.close();
//    }

//    public String[] getAllDVDs() {
//      
//    }

//   
//    public void removeDVD(String name) {
//        allDVDs.remove(name);
//    }

//    
//     public DVD searchByName(String name){
//         return allDVDs.get(name);
//     };
//
//     
//    public List<DVD> searchByDate(String date){
//        List<DVD> dvds
//                = allDVDs.values()
//                .stream()
//                .filter(s -> s.getDate().equalsIgnoreCase(date))
//                .collect(Collectors.toList());
//
//        return dvds;
//    };
//
//    
//    public List<DVD> searchByRating(String rating){
//        List<DVD> dvds
//                = allDVDs.values()
//                .stream()
//                .filter(s -> s.getRating().equalsIgnoreCase(rating))
//                .collect(Collectors.toList());
//
//        return dvds;
//    };
//
//    
//    public Map<String, List<DVD>> searchByDirector(String director){
//        Map<String, List<DVD>> dvds
//                = allDVDs.values()
//                .stream()
//                .filter(s -> s.getDirector().equalsIgnoreCase(director))
//                .collect(Collectors.groupingBy(DVD::getRating));
//
//        return dvds;
//    };
//
//  
//    public List<DVD> searchByStudio(String studio){
//        List<DVD> dvds
//                = allDVDs.values()
//                .stream()
//                .filter(s -> s.getStudio().equalsIgnoreCase(studio))
//                .collect(Collectors.toList());
//
//        return dvds;
//    };
//    
    
    public void getAvgAge(){
//        double averageAge = 
//                allDVDs.values()
//                        .stream()
//                        
//                .mapToString(DVD::getDate)
//                        //.mapToLong(s->s.getServerAge())
//                .average()
//                .getAsDouble();
//        double realAvgAge = 2015-averageAge;
    };

    @Override
    public void add(com.swcguild.dvdlibrary.dto.DVD dvd) {
       
    }

    @Override
    public void remove(int id) {
        allDvds.remove(id);
    }

    @Override
    public List<com.swcguild.dvdlibrary.dto.DVD> listAll() {
    return (List<DVD>) allDvds;
    }

    @Override
    public com.swcguild.dvdlibrary.dto.DVD getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<com.swcguild.dvdlibrary.dto.DVD> getByTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<com.swcguild.dvdlibrary.dto.DVD> getByRating(String rating) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<com.swcguild.dvdlibrary.dto.DVD> getByStudio(String studio) {
        return null;
        
    }
    
}
