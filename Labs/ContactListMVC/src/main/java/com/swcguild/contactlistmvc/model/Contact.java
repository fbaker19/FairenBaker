/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.model;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class Contact {//MODEL  HOLDS DTO's

    /*
     manual entry for hibernate - POM file
    
     <groupId>javax.validation</groupId>
     <artifactId>validation-api</artifactId>
     <version>1.1.0.Final</version>
     */
    private int contactId;

    @NotEmpty(message = "You must supply a value for first name")//hibernate validaion -- can't leave entry blank 
    @Length(max = 50, message = "Name cannot exceed 50 characters in length")  //fyi - manual entry: copy dependency into POM file, maven handles the rest
    private String firstName;

    @NotEmpty(message = "Please supply a value for last name")
    @Length(max = 50, message = "Name cannot exceed 50 characters in length")
    private String lastName;

    @NotEmpty(message = "Please supply the name of your company")
    @Length(max = 50, message = "Company name cannot exceed 50 characters in length")
    private String Company;

    @NotEmpty(message = "Please supply a phone number")
    @Length(max = 10, message = "Number cannot exceed 10 characters in length\nno dashes")
    private String phone;

    @NotEmpty(message = "Please supply a value for lemail")
    @Length(max = 50, message = "Name cannot exceed 50 characters in length")
    private String email;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.contactId;
        hash = 37 * hash + Objects.hashCode(this.firstName);
        hash = 37 * hash + Objects.hashCode(this.lastName);
        hash = 37 * hash + Objects.hashCode(this.Company);
        hash = 37 * hash + Objects.hashCode(this.phone);
        hash = 37 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if (this.contactId != other.contactId) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.Company, other.Company)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
