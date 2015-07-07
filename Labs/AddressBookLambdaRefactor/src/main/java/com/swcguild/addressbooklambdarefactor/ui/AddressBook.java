/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbooklambdarefactor.ui;

//import com.swcguild.addressbooklambdarefactor.dao.LambdaAddressBookDAO;

import com.swcguild.addressbooklambdarefactor.dto.Address;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


/**
 *
 * @author apprentice
 */
public interface AddressBook {//interface  = todo lists - cover the bases
  
    public List<Address> searchByCity( String cityName);

    public List<Address> searchByState( String stateName);

    public List<Address> searchByZip(Integer zip);

    public List<Address> searchNumberAndStreet( String numberAndStreet);

    public List<Address> searchByFirstName( String firstName);

    public List<Address> searchByLastName( String lastName);
    
    
    /**
     * 
     * @param address
     * @return address id number
     */
    public Integer addAddress(Address address);
    
    public void removeAddress (int Id);
    
    public List<Address> getAllAddresses();
    
    public Address getAddress(int Id);//
    
   public void loadAddressBookDAO() throws FileNotFoundException; //*** exceptions must be included in interface
   
   
   public void writeAddressDTO()throws IOException;//***
   
}
