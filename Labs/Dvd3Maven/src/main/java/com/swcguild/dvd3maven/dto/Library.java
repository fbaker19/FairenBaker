/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvd3maven.dto;

import com.swcguild.dvd3maven.dto.LibraryLambda;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface Library {

    public List<LibraryLambda> searchByTitle(String title);

    public List<LibraryLambda> searchByYear(Integer year);

    public List<LibraryLambda> searchByDirector(String director);

    public List<LibraryLambda> searchByMpaa(String mpaa);

    public List<LibraryLambda> searchByRating(float rating);

    public List<LibraryLambda> searchByStudio(String studio);

    public List<LibraryLambda> searchById(Integer Id);

    
    public void loadLibraryLambda() throws FileNotFoundException;

    public void writeLibraryLambda() throws IOException;
    
    public Integer addDvd(LibraryLambda libraries) throws IOException;

    public List<LibraryLambda> getAllTitles();
    
   // public Integer addDvd(LibraryLambda libraries);

    public LibraryLambda getTitle(int Id);

    public void removeTitle(int Id);

    //public void addDvd(Integer id, LibraryLambda currentLibrary);


}
