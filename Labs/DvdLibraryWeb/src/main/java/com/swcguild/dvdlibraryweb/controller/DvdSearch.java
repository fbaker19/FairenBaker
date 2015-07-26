/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryweb.controller;

import com.swcguild.dvdlibraryweb.dao.Library;
import com.swcguild.dvdlibraryweb.model.DVD;
import com.swcguild.dvdlibraryweb.model.DvdSearchTerms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class DvdSearch {

    private Library dao;///import interface

    //injects dao into springframe as a bean
    @Inject
    public DvdSearch(Library dao)//constructor
    {
        this.dao = dao;
    }

    //Orginal- No AJAX Orginal- No AJAX Orginal- No AJAX Orginal- No AJAX Orginal- No AJAX 
    @RequestMapping(value = "/dvdSearch", method = RequestMethod.GET)//refers to spring framework
    public String displaySearchPage() {
        return "dvdSearch";//JSP
    }///END OF ORIGINAL NO AJAX

    @RequestMapping(value = "dvds", method = RequestMethod.POST)
    @ResponseBody public List<DVD> searchDvd(@RequestBody Map<String, String> searchMap)//REQUESTING INFO
    {
        Map<DvdSearchTerms, String> criteriaMap = new HashMap();

        String currentTerm = searchMap.get("title");
        if (!currentTerm.isEmpty()) 
        {
            criteriaMap.put(DvdSearchTerms.TITLE, currentTerm);
        }

        currentTerm = searchMap.get("director");
        if (!currentTerm.isEmpty()) 
        {
            criteriaMap.put(DvdSearchTerms.DIRECTOR, currentTerm);
        }

        currentTerm = searchMap.get("releaseDate");
        if (!currentTerm.isEmpty()) 
        {
            criteriaMap.put(DvdSearchTerms.RELEASE_DATE, currentTerm);
        }

        currentTerm = searchMap.get("mpaa");
        if (!currentTerm.isEmpty()) 
        {
            criteriaMap.put(DvdSearchTerms.MPAA, currentTerm);
        }

        currentTerm = searchMap.get("rating");
        if (!currentTerm.isEmpty()) 
        {
            criteriaMap.put(DvdSearchTerms.RATING, currentTerm);
        }

        currentTerm = searchMap.get("studio");
        if (!currentTerm.isEmpty()) 
        {
            criteriaMap.put(DvdSearchTerms.STUDIO, currentTerm);
        }
      
        return dao.searchDvd(criteriaMap);
    }

}
