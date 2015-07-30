/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.Contact;
import com.swcguild.contactlistmvc.model.SearchTerm;
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
 *  Manual add in for mySQL in POM file(SHOULD NOT HAVE TO DO THIS DUE TO SPRING-ARCHETYPE)
 * 
 * <dependency>
 *      <groupId>mysql</groupId>
 *      <artifactId>mysql-connector-java</artifactId>
 *      <version>5.1.5</version>
 * </dependency>
 *
 * @author apprentice
 */
public class ContactListDaoDbImpl implements ContactListDao {

    //prevents sql injection 
    private static final String SQL_INSERT_CONTACT = "INSERT INTO contacts(first_name, last_name, company, phone, email) VALUES(?,?,?,?,?)";
    private static final String SQL_DELETE_CONTACT = "DELETE FROM contacts WHERE contact_id =?";
    private static final String SQL_UPDATE_CONTACT = "UPDATE contacts set first_name = ?, last_name = ?, company =?, phone = ?, email = ?  WHERE contact_id =?";
    private static final String SQL_SELECT_ALL_CONTACTS = "SELECT * FROM contacts";
    private static final String SQL_SELECT_CONTACT = "SELECT * FROM contacts WHERE contact_id = ?";

    private JdbcTemplate jdbcTemplate; //imported from spring JdbC-Template
/// <property name="jdbcTemplate" ref="jdbcTemplate"/> DO NOT FORGET Place between impl bean//DEAR. GOD.
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)// SPRING IMPORTS-Transactional& propagation
    //locks table until transaction is completed
    public Contact addContact(Contact contact) {
        jdbcTemplate.update(SQL_INSERT_CONTACT,
                //must be in order, otherwise you'll get 'wrong data'
                contact.getFirstName(),
                contact.getLastName(),
                contact.getCompany(),
                contact.getPhone(),
                contact.getEmail());
        //how to set 'last insert ID' - found in database when 'ai ' box is checked
        contact.setContactId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));

        return contact;
    }

    @Override
    public void removeContact(int contactId) {
        jdbcTemplate.update(SQL_DELETE_CONTACT, contactId);
    }

    @Override
    public void updateContact(Contact contact) {
        jdbcTemplate.update(SQL_UPDATE_CONTACT,
                contact.getFirstName(),
                contact.getLastName(),
                contact.getCompany(),
                contact.getPhone(),
                contact.getEmail(),
                contact.getContactId()///WHERE CLAUSE -updating an EXISTING ID 
        );

    }

    @Override
    public List<Contact> getAllContacts() {
        //query = selecting/getting data
        return jdbcTemplate.query(SQL_SELECT_ALL_CONTACTS, new ContactMapper());//see contactMapper class below

    }

    @Override
    public Contact getContactById(int contactId) {//queryForObject selects only ONE object ie 1 entry/contact 
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CONTACT, new ContactMapper(), contactId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {//(k,v iterates over a map (key,value))
        if (criteria == null || criteria.size() == 0) {
            return getAllContacts();
        }
        StringBuilder query = new StringBuilder("SELECT * FROM contacts WHERE ");

        int numParams = criteria.size();

        String[] paramVals = new String[numParams];

        Set<SearchTerm> keyset = criteria.keySet();
        Iterator<SearchTerm> iter = keyset.iterator();

        while (iter.hasNext()) {
            SearchTerm currentKey = iter.next();
            String currentValue = criteria.get(currentKey);

            int paramPosition = 0;

            if (paramPosition > 0) {
                query.append(" and ");
            }

            query.append(currentKey);//SearchTerm parameter/key
            query.append(" =? ");

            paramVals[paramPosition] = currentValue;//String paramerter/value
            paramPosition++;
        }

        return jdbcTemplate.query(query.toString(), new ContactMapper(), paramVals);

    }

    ///implemented from spring 'ParameterizedRowMapper'
    private static final class ContactMapper implements ParameterizedRowMapper<Contact> {

        @Override
        public Contact mapRow(ResultSet rs, int i) throws SQLException {
            
            Contact contact = new Contact();
            
            contact.setContactId(rs.getInt("contact_id"));
            contact.setFirstName(rs.getString("first_name"));
            contact.setLastName(rs.getString("last_name"));
            contact.setCompany(rs.getString("company"));
            contact.setPhone(rs.getString("phone"));
            contact.setEmail(rs.getString("email"));

            return contact;
        }
    }

}
