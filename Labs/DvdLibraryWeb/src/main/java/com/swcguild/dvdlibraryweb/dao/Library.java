/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryweb.dao;

import com.swcguild.dvdlibraryweb.model.DvdSearchTerms;
import com.swcguild.dvdlibraryweb.model.LibraryLambda;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface Library {

    public List<LibraryLambda> searchByTitle(String title);

    public List<LibraryLambda> searchByYear(String year);

    public List<LibraryLambda> searchByDirector(String director);

    public List<LibraryLambda> searchByMpaa(String mpaa);

    public List<LibraryLambda> searchByRating(String rating);

    public List<LibraryLambda> searchByStudio(String studio);

    public List<LibraryLambda> searchById(Integer Id);

    
//    public void loadLibraryLambda() throws FileNotFoundException;
//
//    public void writeLibraryLambda() throws IOException;
    
    public Integer addDvd(LibraryLambda libraries);

    public List<LibraryLambda> getAllTitles();
    
   // public Integer addDvd(LibraryLambda libraries);

    public void updateLibrary(LibraryLambda libraries);
  
    public LibraryLambda getTitle(int Id);

    public void removeTitle(int Id);

    //public void addDvd(Integer id, LibraryLambda currentLibrary);
   public List<LibraryLambda> searchAddress(Map<DvdSearchTerms, String> criteriaMap);//enum
    //searching by map

}
