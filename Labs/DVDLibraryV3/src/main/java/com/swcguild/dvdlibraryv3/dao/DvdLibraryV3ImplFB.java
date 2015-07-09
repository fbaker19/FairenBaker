/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryv3.dao;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.DVD;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 *
 * @author apprentice
 */
public class DvdLibraryV3ImplFB implements DvdLibraryDao{//new uniformed variables
    //creates a hash map of DVD dto(varibles)-- hash map holds variables
    private  Map<Integer, DVD> dvd = new HashMap<>();//NO JAR IN POM
    List<DVD> dvdList = new ArrayList<>();// arraylist places variables in a list to be called upon
    
 @Override
    public void add(DVD dvd) {
        dvdList.add(dvd);
    }

    @Override
    public void remove(int id) {
        dvdList.remove(id);
    }

    @Override
    public List<DVD> listAll() {
        return dvdList;
    }

    @Override
    public DVD getById(int id) {
     DVD results = dvdList// rightside of equals sign is going INTO the left side/return
             .stream()
             .filter(i-> i.getId()==(id))
             .collect(Collectors.toList())
             .get(0); 
           
             return results;    
    }

    @Override
    public List<DVD> getByTitle(String title) {
    
      List<DVD> results = dvdList// rightside of equals sign is going INTO the left side/return
             .stream()
             .filter(i-> i.getTitle().equals(title))
             .collect(Collectors.toList());
             
             return results;    
    }

    @Override
    public List<DVD> getByRating(String rating) {
       List<DVD> results = dvdList// rightside of equals sign is going INTO the left side/return
             .stream()
             .filter(i-> i.getMpaaRating().equals(rating))/// getMpaaRatting is equalivalent to rating/parameter
             .collect(Collectors.toList());
             
             return results;   
    }

    @Override
    public List<DVD> getByStudio(String studio) {
        List<DVD> results = dvdList// rightside of equals sign is going INTO the left side/return
             .stream()
             .filter(i-> i.getStudio().equals(studio))
             .collect(Collectors.toList());
             
             return results; 
    }

   
}
