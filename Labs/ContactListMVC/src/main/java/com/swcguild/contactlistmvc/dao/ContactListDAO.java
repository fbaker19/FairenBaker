/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.Contact;
import com.swcguild.contactlistmvc.model.SearchTerm;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface ContactListDAO {
    
    public Contact addContact(Contact contactVar);
   
    public void  removeContact(int contactId);
    
    public void updateContact(Contact contactVar);
    
    public List<Contact> getAllContacts();
    
    public Contact getContactById(int contactId);//????
    
    public List<Contact> searchContacts(Map<SearchTerm, String> criteriaMap);//enum
    //searching by map
    
    
}
