/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryweb.dao;

//import com.swcguild.dvdlambda.DVD;
import com.swcguild.dvdlibraryweb.model.DvdSearchTerms;
import com.swcguild.dvdlibraryweb.model.DVD;
import com.swcguild.dvdlibraryweb.dao.Library;
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
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DVDLibraryImpl implements Library {
//
//    public static final String DVDLIBRARY_FILE = "DvdLibrary.txt";//1 import file & Delimiter
//    public static final String DELIMITER = "::"; //Delimiter = ::

    private final Map<Integer, DVD> libraryMap = new HashMap<>();//2/ import DTO Class

    List<DVD> librariesList = new ArrayList<>();// creates a list from DTO

    @Override
    public List<DVD> getAllTitles() {
        //Set<Integer> keySet = libraryMap.keySet();//sets array size
        
        List<DVD> lList = new ArrayList<>(libraryMap.values());///constuctor of Array List<>()
        return lList;

    }
//
//    @Override
//    public List<DVD> searchByTitle(String title) {
//        return (List<DVD>) libraryMap.values()
//                .stream()
//                .filter(d -> d.getTitle().equalsIgnoreCase(title))
//                .collect(Collectors.toList());
//
//    }
//
//    @Override
//    public List<DVD> searchByYear(String year) {
//        return (List<DVD>) libraryMap.values()
//                .stream()
//                .filter((DVD d) -> year.equals(d.getYear()))
//                .collect(Collectors.toList());
//
//    }
//
//    @Override
//    public List<DVD> searchByDirector(String director) {
//        return libraryMap.values()
//                .stream()
//                .filter(d -> d.getDirector().equalsIgnoreCase(director))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<DVD> searchByMpaa(String mpaa) {
//        return libraryMap.values()
//                .stream()
//                .filter(d -> d.getMpaa().equalsIgnoreCase(mpaa))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<DVD> searchByRating(String rating) {
//        return libraryMap.values()
//                .stream()
//                .filter((DVD d) -> d.getRating().equals(rating))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<DVD> searchByStudio(String studio) {
//        return libraryMap.values()
//                .stream()
//                .filter(d -> d.getStudio().equalsIgnoreCase(studio))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<DVD> searchById(Integer Id) {
//        return libraryMap.values()
//                .stream()
//                .filter(d -> d.getId().equals(Id))
//                .collect(Collectors.toList());
//    }

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
    public DVD getTitle(int Id) {///remember to pass in the paramater (Via get.)

        return libraryMap.get(Id);
    }

//    @Override
//    public Integer addDvd(DVD librariesList) {
//        librariesList.setId(nextID()); 
//       libraryMap.put(librariesList.getId(),librariesList);
//       return librariesList.getId();
//    }
    @Override
    public void removeTitle(int Id) {
        libraryMap.remove(Id);//removes from the hashmap by Id       
    }

    @Override
    public Integer addDvd(DVD librariesList) {
        librariesList.setId(nextID());
        libraryMap.put(librariesList.getId(), librariesList);
        return librariesList.getId();
    }

    /**
     *
     * @throws FileNotFoundException
     */
//    @Override
//    public void loadLibraryLambda() throws FileNotFoundException {
//        Scanner sc = new Scanner(new BufferedReader(new FileReader(DVDLIBRARY_FILE)));//Import Scanner (BufferedReader(FileReader(FILENAME_FILE)));
//        String currentLine;
//        String[] currentTokens;//ARRAY LIST
//        // work on controller after steps completed above
//
//        while (sc.hasNextLine()) {
//            currentLine = sc.nextLine();
//
//            currentTokens = currentLine.split(DELIMITER);// array
//if(currentTokens.length>1)
//{
//    
//
//            DVD currentLibrary = new DVD(Integer.parseInt(currentTokens[0]));//ID
//
//            currentLibrary.setTitle(currentTokens[1]);
//            currentLibrary.setDirector(currentTokens[2]);
//            currentLibrary.setYear(Integer.parseInt(currentTokens[3]));
//            currentLibrary.setMpaa(currentTokens[4]);
//            currentLibrary.setRating(Float.parseFloat(currentTokens[5]));//user rating
//            currentLibrary.setStudio(currentTokens[6]);
//
//            libraryMap.put(currentLibrary.getId(), currentLibrary);//what to search by
//            }
//            
//        }
//        sc.close();
//    }
//
//    public void writeLibraryLambda() throws IOException {
//        PrintWriter out = new PrintWriter(new FileWriter(DVDLIBRARY_FILE));
//        List<LibraryLambda> libraries = this.getAllTitles();//creates 'get' method w/in DAO(this class)
//
//        for (DVD currentLibrary : libraries) {//what is is returning(String, Integer, List, ect) element(current__): arrayName
//
//          out.println(currentLibrary.getId() + DELIMITER// ADDED ID
//                    + currentLibrary.getTitle() + DELIMITER
//                    + currentLibrary.getDirector() + DELIMITER
//                    + currentLibrary.getYear() + DELIMITER
//                    + currentLibrary.getMpaa() + DELIMITER
//                    + currentLibrary.getRating() + DELIMITER
//                  
//                    + currentLibrary.getStudio());
//
//            out.flush();
//        }
//        out.close();
//    }

    /**
     *
     * @param libraries
     * @throws FileNotFoundException
     */
    @Override
    public void updateLibrary(DVD libraries) {
        libraryMap.put(libraries.getId(), libraries);
    }

   

    @Override
    public List<DVD> searchDvd(Map<DvdSearchTerms, String> criteriaMap) {
       
        String titleCriteria = criteriaMap.get(DvdSearchTerms.TITLE);
        String directorCriteria = criteriaMap.get(DvdSearchTerms.DIRECTOR);
        String releaseDateCriteria = criteriaMap.get(DvdSearchTerms.RELEASE_DATE);
        String mpaaCriteria = criteriaMap.get(DvdSearchTerms.MPAA);
        String ratingCriteria = criteriaMap.get(DvdSearchTerms.RATING);
        String studioCriteria = criteriaMap.get(DvdSearchTerms.STUDIO);
        
        Predicate<DVD> titleMatches;
        Predicate<DVD> directorMatches;
        Predicate<DVD> releaseDateMatches;
        Predicate<DVD> mpaaMatches;
        Predicate<DVD> ratingMatches;
        Predicate<DVD> studioMatches;
        
        Predicate<DVD> truePredicate = (c) -> {return true;};
        
        titleMatches = (titleCriteria == null || titleCriteria.isEmpty())?
                            truePredicate
                : (c) -> c.getTitle().equalsIgnoreCase(titleCriteria);
        
        directorMatches = (directorCriteria == null || directorCriteria.isEmpty())?
                            truePredicate
                : (c) -> c.getDirector().equalsIgnoreCase(directorCriteria);
        
        releaseDateMatches = (releaseDateCriteria == null || releaseDateCriteria.isEmpty())?
                            truePredicate
                : (c) -> c.getReleaseDate().equalsIgnoreCase(releaseDateCriteria);
        
       mpaaMatches = ( mpaaCriteria == null ||  mpaaCriteria.isEmpty())?
                            truePredicate
                : (c) -> c.getMpaa().equalsIgnoreCase( mpaaCriteria);
        
        ratingMatches = (ratingCriteria == null || ratingCriteria.isEmpty())?
                            truePredicate
                : (c) -> c.getRating().equalsIgnoreCase(ratingCriteria);
        
        studioMatches = (studioCriteria == null || studioCriteria.isEmpty())?
                            truePredicate
                : (c) -> c.getStudio().equalsIgnoreCase(studioCriteria);
        
        return libraryMap.values().stream()
                    .filter(titleMatches 
                                .and(directorMatches)
                                .and(releaseDateMatches)
                                .and(mpaaMatches)
                                .and(ratingMatches)
                                .and(studioMatches)
                    )
                    .collect(Collectors.toList());
    }

 


}
