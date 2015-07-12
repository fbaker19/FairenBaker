/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplecontacts.dao;

import com.swcguild.simplecontacts.dto.Contact;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class ContactsDAOMockImple implements ContactsDAO {

    @Override
    public List<Contact> getContacts() {

        List<Contact> conList = new ArrayList<>();//array list of the DTO
        Contact c1 = new Contact();

        c1.setName("John doe");
        c1.setPhone("330-555-1212");
        c1.setEmail("jdoe@joe.com");

        conList.add(c1);//add c1 variables to array list

        c1 = new Contact();
        c1.setName("Sally Smith");
        c1.setPhone("330-555-4455");
        c1.setEmail("smith@smith.com");

        conList.add(c1);//add c1 variables to array list

        c1 = new Contact();
        c1.setName("Bert Johnson");
        c1.setPhone("330-555-6105");
        c1.setEmail("bjohnson@mail.com");

        conList.add(c1);//add c1 variables to array list

        return conList;
    }
    
}
