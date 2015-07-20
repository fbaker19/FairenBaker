/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.controller;

import com.swcguild.contactlistmvc.dao.ContactListDAO;
import com.swcguild.contactlistmvc.model.Contact;
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
 * @author ilyagotfryd
 */
@Controller
//@RequestMapping(value="/")
public class HomeController {
    
    
    private ContactListDAO dao;
    
    @Inject
    public HomeController(ContactListDAO dao) {
        this.dao = dao;
    }
    
    //ORIGINAL(Pre_AJAX) ORIGINAL(Pre_AJAX) ORIGINAL(Pre_AJAX) ORIGINAL(Pre_AJAX) ORIGINAL(Pre_AJAX) ORIGINAL(Pre_AJAX)
    @RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
    public String displayHomePage()
    {
        return "home";
    }
    
    /////AJAX AJAX AJAX AJAX AJAX AJAX AJAX AJAX AJAX AJAX AJAX AJAX AJAX AJAX //////
    @RequestMapping(value="/contact/{contactId}", method=RequestMethod.GET)
    @ResponseBody public Contact getContact(@PathVariable("contactId") int contactId) {
        return dao.getContactById(contactId);
    }
    
    
    
    @RequestMapping(value="/contact", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody 
    public Contact createContact(@Valid @RequestBody Contact contact) {
        dao.addContact(contact);
        return contact;
    }
    

    @RequestMapping(value="/contact/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable("id") int id) {
        dao.removeContact(id);
    }
    
    
    
    @RequestMapping(value="/contact/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putContact(@PathVariable("id") int id, @RequestBody Contact contact) {
        contact.setContactId(id);
        dao.updateContact(contact);
    }
    
    
    @RequestMapping(value="/contacts", method=RequestMethod.GET)
    @ResponseBody public List<Contact> getAllContacts() {
        return dao.getAllContacts();
    }
    
    
    
}