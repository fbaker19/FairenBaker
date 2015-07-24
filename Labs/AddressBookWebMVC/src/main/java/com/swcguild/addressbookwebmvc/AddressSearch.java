/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookwebmvc;

import com.swcguild.addressbookwebmvc.dao.AddressInterface;
import com.swcguild.addressbookwebmvc.model.Address;
import com.swcguild.addressbookwebmvc.model.AddressSearchTerm;
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
public class AddressSearch {
    
      private AddressInterface  dao;
   
    @Inject
    public AddressSearch(AddressInterface dao)
    {
        this.dao = dao;
    }
    
 @RequestMapping(value ="/addressSearch",method=RequestMethod.GET)
 public String displaySearch()
         
 {
     return "addressSearch";//JSP
 }
 
  
    @RequestMapping(value = "addressbook", method= RequestMethod.POST)
    @ResponseBody public List<Address> searchAddresses(@RequestBody Map<String,String> searchMap)
    {
          Map<AddressSearchTerm,String> criteriaMap = new HashMap();
      
        String currentTerm = searchMap.get("firstName");
        if(!currentTerm.isEmpty())
        {
            criteriaMap.put(AddressSearchTerm.FIRST_NAME, currentTerm);
        }
    
        
        currentTerm = searchMap.get("lastName");
        if(!currentTerm.isEmpty())
        {
            criteriaMap.put(AddressSearchTerm.LAST_NAME, currentTerm);
        }
         
        currentTerm = searchMap.get("numberAndStreet");
        if(!currentTerm.isEmpty())
        {
            criteriaMap.put(AddressSearchTerm.NUMBER_AND_STREET, currentTerm);
        }
         
        
        currentTerm = searchMap.get("city");
        if(!currentTerm.isEmpty())
        {
            criteriaMap.put(AddressSearchTerm.CITY, currentTerm);
        }
         
        currentTerm = searchMap.get("state");
        if(!currentTerm.isEmpty())
        {
            criteriaMap.put(AddressSearchTerm.STATE, currentTerm);
        }
       
        
        currentTerm = searchMap.get("zip");
        if(!currentTerm.isEmpty())
        {
            criteriaMap.put(AddressSearchTerm.ZIP, currentTerm);
        }
        return dao.searchAddress(criteriaMap);
    }
    
}
