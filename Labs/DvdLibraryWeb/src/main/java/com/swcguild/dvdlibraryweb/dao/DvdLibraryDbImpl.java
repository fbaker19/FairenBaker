/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryweb.dao;

import com.swcguild.dvdlibraryweb.model.DVD;
import com.swcguild.dvdlibraryweb.model.DvdSearchTerms;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class DvdLibraryDbImpl implements Library{//implement the Interface
    
 private static final String SQL_INSERT_DVD = "INSERT INTO dvd (title, director)";   
    
    
    
    
    
    
    
    
    
    
    

    @Override
    public Integer addDvd(DVD libraries) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getAllTitles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateLibrary(DVD libraries) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD getTitle(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTitle(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> searchDvd(Map<DvdSearchTerms, String> criteriaMap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
