/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlambda;

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
public class DVDLibraryImpl implements Library {

    public static final String DVDLIBRARY1_FILE = "DVDLibrary1.txt";//1 import file & Delimiter
    public static final String DELIMITER = "::"; //Delimiter = ::

    private Map<Integer, LibraryLambda> libraryMap = new HashMap<>();//2/ import DTO Class

    List<LibraryLambda> libraries = new ArrayList<>();// creates a list from DTO

    public List<LibraryLambda> getAllTitles() {
        //Set<Integer> keySet = libraryMap.keySet();//sets array size
        List<LibraryLambda> libraries = new ArrayList<>(libraryMap.values());///constuctor of Array List<>()
        return libraries;

    }

    @Override
    public List<LibraryLambda> searchByTitle(String title) {
        return (List<LibraryLambda>) libraryMap.values()
                .stream()
                .filter(d -> d.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());

    }

    @Override
    public List<LibraryLambda> searchByYear(Integer year) {
        return (List<LibraryLambda>) libraryMap.values()
                .stream()
                .filter((LibraryLambda d) -> year.equals(d.getYear()))
                .collect(Collectors.toList());

    }

    @Override
    public List<LibraryLambda> searchByDirector(String director) {
        return libraryMap.values()
                .stream()
                .filter(d -> d.getDirector().equalsIgnoreCase(director))
                .collect(Collectors.toList());
    }

    @Override
    public List<LibraryLambda> searchByMpaa(String mpaa) {
        return libraryMap.values()
                .stream()
                .filter(d -> d.getMpaa().equalsIgnoreCase(mpaa))
                .collect(Collectors.toList());
    }

    @Override
    public List<LibraryLambda> searchByRating(float rating){
        return libraryMap.values()
                .stream()
                .filter((LibraryLambda d) -> d.getRating()==rating)
                .collect(Collectors.toList());
    }

    @Override
    public List<LibraryLambda> searchByStudio(String studio) {
        return libraryMap.values()
                .stream()
                .filter(d -> d.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());
    }

    @Override
    public List<LibraryLambda> searchById(Integer Id) {
        return libraryMap.values()
                .stream()
                .filter(d -> d.getId().equals(Id))
                .collect(Collectors.toList());
    }

    private Integer nextID() {
        if (libraryMap == null || libraryMap.isEmpty()) {
            return 0;
        }
        Integer id = libraryMap.keySet()
                .stream()
                /**
                 * Comparator for Lambda
                 */
                .max((Integer val1, Integer val2) -> {
                    return val1.compareTo(val2);
                })
                .get();//optional to get integer/int 

        return id + 1;

    }

    @Override
    public LibraryLambda getTitle(int Id) {
     
        return (LibraryLambda) libraryMap;
    }

//    @Override
//    public Integer addDvd(LibraryLambda libraries) {
//        libraries.setId(nextID()); 
//       libraryMap.put(libraries.getId(),libraries);
//       return libraries.getId();
//    }
    @Override
    public void removeTitle(int Id) {
        libraryMap.remove(Id);//removes from the hashmap by Id       
    }

    @Override
    public Integer addDvd(LibraryLambda libraries) throws IOException {
        libraries.setId(nextID());
        libraryMap.put(libraries.getId(), libraries);
        return libraries.getId();
    }

    public void loadLibraryLambda() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(DVDLIBRARY1_FILE)));//Import Scanner (BufferedReader(FileReader(FILENAME_FILE)));
        String currentLine;
        String[] currentTokens;//ARRRAY LIST
        // work on controller after steps completed above

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);// array

            LibraryLambda currentLibrary = new LibraryLambda(currentTokens[0]);
          //imports DTO class &creates new constructor in DTO -- change into constructor >> this."___" 

            //setters - currentDTO.set
            // currentLibrary.setTitle(currentTokens[0]);//needed?
            currentLibrary.setDirector(currentTokens[1]);
            currentLibrary.setYear(Integer.parseInt(currentTokens[2]));
            currentLibrary.setMpaa(currentTokens[3]);
            currentLibrary.setRating(Float.parseFloat(currentTokens[4]));//user rating
            currentLibrary.setStudio(currentTokens[5]);

            libraryMap.put(currentLibrary.getId(), currentLibrary);//what to search by
        }
        sc.close();
    }

    public void writeLibraryLambda() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(DVDLIBRARY1_FILE));
        List<LibraryLambda> libraries = this.getAllTitles();//creates 'get' method w/in DAO(this class)

        for (LibraryLambda currentLibrary : libraries) {//what is is returning(String, Integer, List, ect) element(current__): arrayName

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

}