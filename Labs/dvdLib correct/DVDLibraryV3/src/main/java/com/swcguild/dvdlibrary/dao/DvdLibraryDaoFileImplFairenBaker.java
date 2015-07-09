/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.dao;

import com.swcguild.dvdlibrary.dto.DVD;
import com.swcgulid.dvdlibrary.dto.Dvd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class DvdLibraryDaoFileImplFairenBaker implements DvdLibraryDao {///DVDLibInterface
    HashMap<String, DVD> allDVDs = new HashMap<String, DVD>();
    List<DVD> dvd = new ArrayList<>();
    
    @Override
    public void add(DVD dvd) {
      allDVDs.values();

    }

    @Override
    public void remove(int id) {
        allDVDs.values();
    }

    @Override
    public List<DVD> listAll() {
       List<DVD> dvd = new ArrayList<>(allDVDs.values());///constuctor of Array List<>()
        return dvd;
             
    }

    @Override
    public DVD getById(int id) {
        return null;
    }

    @Override
    public List<DVD> getByTitle(String title) {

    }

    @Override
    public List<DVD> getByRating(String rating) {

    }

    @Override
    public List<DVD> getByStudio(String studio) {

    }
    
    
}
