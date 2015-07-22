/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryweb.controller;

import com.swcguild.dvdlibraryweb.dao.Library;
import com.swcguild.dvdlibraryweb.model.LibraryLambda;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
public class DvdAjaxController {

    private Library dao;//interface

    @Inject////Spring goes thru and finds the bean that implements the interface that matches the interface below
    public DvdAjaxController(Library dao) {
        this.dao = dao;
    }


    //ORIGINAL HOME SETUP (see home Controller)
    @RequestMapping(value = {"/", "/dvdHome"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "dvdHome";
    }

///AJAX BEGINS
    @RequestMapping(value = "/dvdLibrary/{dvdId}", method = RequestMethod.GET)//dvdId vs id
    @ResponseBody
    public LibraryLambda getDvd(@PathVariable("dvdId") int id) {
        return dao.getTitle(id);///pull this from DTO 
    }

    @RequestMapping(value = "/dvdLibrary", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public LibraryLambda createDvd(@Valid @RequestBody LibraryLambda ll) {
        dao.addDvd(ll);///Pull from dto
        return ll;
    }

    @RequestMapping(value = "/dvdLibrary/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDvd(@PathVariable("id") int id) {
        dao.removeTitle(id);//pull from dto
    }

    @RequestMapping(value = "/dvdLibrary/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putDvd(@PathVariable("id") int id, @RequestBody LibraryLambda ll) {///imports 
        ll.setId(id);
        dao.updateLibrary(ll);
    }

    @RequestMapping(value = "/dvds", method = RequestMethod.GET)
    @ResponseBody
    public List<LibraryLambda> getAllTitles() {
        return dao.getAllTitles();
    }

}
