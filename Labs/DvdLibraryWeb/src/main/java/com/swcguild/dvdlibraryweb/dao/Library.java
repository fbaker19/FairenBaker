/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryweb.dao;

import com.swcguild.dvdlibraryweb.model.DvdSearchTerms;
import com.swcguild.dvdlibraryweb.model.DVD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface Library {

    public List<DVD> searchByTitle(String title);

    public List<DVD> searchByYear(String year);

    public List<DVD> searchByDirector(String director);

    public List<DVD> searchByMpaa(String mpaa);

    public List<DVD> searchByRating(String rating);

    public List<DVD> searchByStudio(String studio);

    public List<DVD> searchById(Integer Id);

    
//    public void loadLibraryLambda() throws FileNotFoundException;
//
//    public void writeLibraryLambda() throws IOException;
    
    public Integer addDvd(DVD libraries);

    public List<DVD> getAllTitles();
    
   // public Integer addDvd(DVD libraries);

    public void updateLibrary(DVD libraries);
  
    public DVD getTitle(int Id);

    public void removeTitle(int Id);

    //public void addDvd(Integer id, DVD currentLibrary);
   public List<DVD> searchAddress(Map<DvdSearchTerms, String> criteriaMap);//enum
    //searching by map

}
