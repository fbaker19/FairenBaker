/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.Contact;
import com.swcguild.contactlistmvc.model.SearchTerm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class ContactListDaoInMapImple implements ContactListDAO {

    private Map<Integer, Contact> contactMap = new HashMap<>();//helps search by Id with Interger(id)  assigned by 'Contact' DTO ( getters & setters)
    private static int contactIdCounter = 0;

    @Override
    public Contact addContact(Contact contactVar) {
        contactVar.setContactId(contactIdCounter);//contactVar sets Id to variable of contactId
        contactIdCounter++;
        contactMap.put(contactVar.getContactId(), contactVar);//places counter in local class hashmap
        return contactVar;//returns the id set to contactVar

    }

    @Override
    public void removeContact(int contactId) {
        contactMap.remove(contactId);
    }

    @Override
    public void updateContact(Contact contactVar) {
        contactMap.put(contactVar.getContactId(), contactVar);
    }

    @Override
    public List<Contact> getAllContacts() {
        Collection<Contact> c = contactMap.values();
        return new ArrayList<>(c);
    }

    @Override
    public Contact getContactById(int contactId) {
        return contactMap.get(contactId);
    }

    @Override
    public List<Contact> searchContacts(Map<SearchTerm, String> criteriaMap) {

        String firstNameCriteria = criteriaMap.get(SearchTerm.FIRST_NAME);//criteriaMap gets the enum
        String lastNameCriteria = criteriaMap.get(SearchTerm.LAST_NAME);
        String companyCriteria = criteriaMap.get(SearchTerm.COMPANY);
        String phoneCriteria = criteriaMap.get(SearchTerm.PHONE);
        String emailCriteria = criteriaMap.get(SearchTerm.EMAIL);

        Predicate<Contact> firstNameMatches;
        Predicate<Contact> lastNameMatches;
        Predicate<Contact> companyMatches;
        Predicate<Contact> phoneMatches;
        Predicate<Contact> emailMatches;
        

        Predicate<Contact> truePredicate = (c) -> {
            return true;
        }; 
        
            //if statement(null || 'isEmpty Criteria/var') ': else statement(Lambda)

        
        firstNameMatches = (firstNameCriteria == null || firstNameCriteria.isEmpty()) ?// ternary operator 
                truePredicate//if (search by everything)
                : (c) -> c.getFirstName().equalsIgnoreCase(firstNameCriteria);//else (search by specified....ie 'firstName')

        lastNameMatches = (lastNameCriteria == null || lastNameCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getLastName().equalsIgnoreCase(lastNameCriteria);

        companyMatches = (companyCriteria == null || companyCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getCompany().equalsIgnoreCase(companyCriteria);

        phoneMatches = (phoneCriteria == null || phoneCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getPhone().equalsIgnoreCase(phoneCriteria);

        emailMatches = (emailCriteria == null || emailCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getEmail().equalsIgnoreCase(emailCriteria);

        return contactMap.values()
                .stream()
                .filter(firstNameMatches
                    .and(lastNameMatches)
                    .and(companyMatches)
                    .and(phoneMatches)
                    .and(emailMatches))
                .collect(Collectors.toList());

    }

}
