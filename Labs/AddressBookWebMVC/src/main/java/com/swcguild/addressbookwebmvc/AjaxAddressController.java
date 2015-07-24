/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookwebmvc;

import com.swcguild.addressbookwebmvc.dao.AddressInterface;
import com.swcguild.addressbookwebmvc.model.Address;
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
public class AjaxAddressController {
    private AddressInterface dao;
    
    @Inject// injects dao into bean/springframework
      public AjaxAddressController(AddressInterface dao) {
        this.dao = dao;
    }
      ///AJAX BEGINS
    @RequestMapping(value = "/address/{addressId}", method = RequestMethod.GET)//dvdId vs id
    @ResponseBody
    public Address getAddress(@PathVariable("addressId") int id) {//or  'id'
        return dao.getAddressId(id);///pull this from DTO 
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Address createAddress(@Valid @RequestBody Address ab) {//see Validation package and Model/DTO for hibernation imports
        dao.addAddress(ab);///Pull from dto  - var == addressVar
        return ab;
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable("id") int id) {
        dao.removeAddress(id);//;//pull from dto
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putAddress(@PathVariable("id") int id, @RequestBody Address ab) {///imports 
       ab.setId(id);
       dao.updateAddress(ab);//used to be addressVar parameter
    }

    @RequestMapping(value = "/addressbook", method = RequestMethod.GET)
    @ResponseBody
    public List<Address> getAllAddresses() {
        return dao.getAllAddresses();
    }
//@RequestMapping(value = "/addressbook", method = RequestMethod.POST)
//
//    @ResponseBody
//    public List<Address> searchAddress() {
//        //dao.addAddress(ab);///Pull from dto  - var == addressVar
//        return dao.getAllAddresses();
//    }
        

}
