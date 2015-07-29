/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookwebmvc.dao;

import com.swcguild.addressbookwebmvc.model.Address;
import com.swcguild.addressbookwebmvc.model.AddressSearchTerm;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class AddressBookDbImpl implements AddressInterface {

    ///injects into database :"INSERT INTO dataBaseName(fields of Database) VALUES(?,?,?.....)
    public static final String SQL_INSERT_ADDRESS = "INSERT INTO address(first_name, last_name, number_and_street, city, state, zip) VALUES(?,?,?,?,?,?)" ;
    public static final String SQL_DELETE_ADDRESS ="DELETE FROM address WHERE id = ?";
    public static final String SQL_UPDATE_ADDRESS ="UPDATE address set first_name = ?, last_name =?, number_and_street =?, city =?, state=?, zip=?";
    public static final String SQL_SELECT_ALL_ADDRESSES="SELECT * FROM address";
    public static final String SQL_SELECT_ADDRESS ="SELECT * FROM address WHERE is = ?";
   
    private JdbcTemplate jdbcTemplate; //imported from spring JdbC-Template
   
    //sets imports into the parameter
    public void setJdbcTemplate (JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Method step 1
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false) //locks table until transaction is completed
    public Integer addAddress(Address address) {
        jdbcTemplate.update(SQL_INSERT_ADDRESS,//"get" the address as an input from user
                //must be in order, otherwise you' get 'wrong data'
                address.getFirstName(),
                address.getLastName(),
                address.getNumberAndStreet(),
                address.getCity(),
                address.getState(),
                address.getZip());
       
        //how to set 'last insert ID' - found in database when 'ai ' box is checked
        address.setId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()",Integer.class));
      
        return address.getId();
    }
   // Method step 2
    @Override
    public void removeAddress(int Id) {
        jdbcTemplate.update(SQL_DELETE_ADDRESS, Id);
    }

    //Method step 5
    @Override
    public List<Address> getAllAddresses() {//query = selecting/getting data
        return jdbcTemplate.query(SQL_SELECT_ALL_ADDRESSES, new AddressMapper());
    }
    
    //Method step 6
    @Override //queryForObject selects only ONE object ie 1 entry/contact 
    public Address getAddressId(int id) {
        try
        {
            return jdbcTemplate.queryForObject(SQL_SELECT_ADDRESS, new AddressMapper(), id);
        } catch(EmptyResultDataAccessException ex)
        
        {
            return null;
        }
    }

    //Method Step 3
    @Override
    public void updateAddress(Address addressVar) {
        //"get" to pull information so that it may be updated
        jdbcTemplate.update(SQL_UPDATE_ADDRESS,
                addressVar.getFirstName(),
                addressVar.getLastName(),
                addressVar.getNumberAndStreet(),
                addressVar.getCity(),
                addressVar.getState(),
                addressVar.getZip(),
               
                addressVar.getId()///WHERE CLAUSE -updating an EXISTING ID 
        );
    }

    //Method  step 7[final]
    @Override
    public List<Address> searchAddress(Map<AddressSearchTerm, String> criteriaMap) {
            if (criteriaMap == null || criteriaMap.size() == 0) {
            return getAllAddresses();
        }
        StringBuilder query = new StringBuilder("SELECT * FROM contacts WHERE ");

        int numParams = criteriaMap.size();

        String[] paramVals = new String[numParams];

        Set<AddressSearchTerm> keyset = criteriaMap.keySet();
        Iterator<AddressSearchTerm> iter = keyset.iterator();//iterarot is for looping an array
        
        int paramPosition = 0;// starting postiion
       
        while (iter.hasNext()) {
            AddressSearchTerm currentKey = iter.next();// looping to thr new value on the list
            String currentValue = criteriaMap.get(currentKey);// gets value by key(fields)


            if (paramPosition > 0) {
                query.append(" and ");//space sensative
            }

            query.append(currentKey);//SearchTerm parameter/key
            query.append(" =? ");  //space sensative

            paramVals[paramPosition] = currentValue;//String paramerter/value
            paramPosition++; //moves down the list and reads  variables doen
        }

        return jdbcTemplate.query(query.toString(), new AddressMapper(), paramVals);
    }
    
    //Method step 4
    private static final class AddressMapper implements ParameterizedRowMapper<Address>
    {

        @Override
        public Address mapRow(ResultSet rs, int i) throws SQLException {//implemented from spring 'ParameterizedRowMapper'
            
            Address address = new Address();
            
            address.setId(rs.getInt("id"));
            address.setFirstName(rs.getString("first_name"));
            address.setLastName(rs.getString("last_name"));
            address.setNumberAndStreet(rs.getString("number_and_street"));
            address.setCity(rs.getString("city"));
            address.setState(rs.getString("state"));
            address.setZip(rs.getString("zip"));
            
            return address;
        }
        
    }
    
}
