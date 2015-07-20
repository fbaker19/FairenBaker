/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlambda;

import com.swcguild.dvdlambda.LibraryLambda;
//import swcguild.dvdlibraryweb.dao.Library;
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

    public static final String DVDLIBRARY_FILE = "DvdLibrary.txt";//1 import file & Delimiter
    public static final String DELIMITER = "::"; //Delimiter = ::

    private Map<Integer, LibraryLambda> libraryMap = new HashMap<>();//2/ import DTO Class

    List<LibraryLambda> librariesList = new ArrayList<>();// creates a list from DTO

    public List<LibraryLambda> getAllTitles() {
        //Set<Integer> keySet = libraryMap.keySet();//sets array size
        
        List<LibraryLambda> librariesList = new ArrayList<>(libraryMap.values());///constuctor of Array List<>()
        return librariesList;

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
    public List<LibraryLambda> searchByRating(float rating) {
        return libraryMap.values()
                .stream()
                .filter((LibraryLambda d) -> d.getRating() == rating)
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

    /**
     * Comparator for Lambda
     */
    private Integer nextID() {
        if (libraryMap == null || libraryMap.isEmpty()) {
            return 0;
        }
        Integer id = libraryMap.keySet()
                .stream()
                .max((Integer val1, Integer val2) -> {
                    return val1.compareTo(val2);
                })
                .get();    //optional to get integer/int 

        return id + 1;

    }
 @Override
    public LibraryLambda getTitle(int Id) {

        return (LibraryLambda)  libraryMap;
    }

//    @Override
//    public Integer addDvd(LibraryLambda librariesList) {
//        librariesList.setId(nextID()); 
//       libraryMap.put(librariesList.getId(),librariesList);
//       return librariesList.getId();
//    }
    @Override
    public void removeTitle(int Id) {
        libraryMap.remove(Id);//removes from the hashmap by Id       
    }

    @Override
    public Integer addDvd(LibraryLambda librariesList) throws IOException {
        librariesList.setId(nextID());
        libraryMap.put(librariesList.getId(), librariesList);
        return librariesList.getId();
    }

    /**
     *
     * @throws FileNotFoundException
     */
    @Override
    public void loadLibraryLambda() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(DVDLIBRARY_FILE)));//Import Scanner (BufferedReader(FileReader(FILENAME_FILE)));
        String currentLine;
        String[] currentTokens;//ARRAY LIST
        // work on controller after steps completed above

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();

            currentTokens = currentLine.split(DELIMITER);// array
if(currentTokens.length>1)
{
    

            LibraryLambda currentLibrary = new LibraryLambda(Integer.parseInt(currentTokens[0]));//ID

            currentLibrary.setTitle(currentTokens[1]);
            currentLibrary.setDirector(currentTokens[2]);
            currentLibrary.setYear(Integer.parseInt(currentTokens[3]));
            currentLibrary.setMpaa(currentTokens[4]);
            currentLibrary.setRating(Float.parseFloat(currentTokens[5]));//user rating
            currentLibrary.setStudio(currentTokens[6]);

            libraryMap.put(currentLibrary.getId(), currentLibrary);//what to search by
            }
            
        }
        sc.close();
    }

    public void writeLibraryLambda() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(DVDLIBRARY_FILE));
        List<LibraryLambda> libraries = this.getAllTitles();//creates 'get' method w/in DAO(this class)

        for (LibraryLambda currentLibrary : libraries) {//what is is returning(String, Integer, List, ect) element(current__): arrayName

          out.println(currentLibrary.getId() + DELIMITER// ADDED ID
                    + currentLibrary.getTitle() + DELIMITER
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
