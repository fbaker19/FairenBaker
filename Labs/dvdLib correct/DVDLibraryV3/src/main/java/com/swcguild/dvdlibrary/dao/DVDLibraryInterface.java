/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.dao;

import com.swcgulid.dvdlibrary.dto.Dvd;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DVDLibraryInterface {
   
    public void loadDVDLibrary() throws FileNotFoundException;

    public void addDVD(String name, Dvd currentDVD);

    public void removeDVD(String name);

    public String[] getAllDVDs();

    public void writeDVDs() throws IOException;

    public Dvd searchByName(String name);

    public List<Dvd> searchByDate(String date);

    public List<Dvd> searchByRating(String rating);

    public Map<String, List<Dvd>> searchByDirector(String director);

    public List<Dvd> searchByStudio(String studio);

    public void getAvgAge();
}
