/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.testtorun.model;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
//Hibernate validators =@Length(max,message), @NotEmpty(message)

public class Address {
    private Integer id;
    private String city;
    private String state;
    private String firstName;
    private String lastName;
    private String zip;
    private String numberAndStreet;

   
    public Address(String lastName) {
        this.lastName = lastName;
    }

    public Address() {
        //this.lastName = lastName;  
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getNumberAndStreet() {
        return numberAndStreet;
    }

    public void setNumberAndStreet(String numberAndStreet) {
        this.numberAndStreet = numberAndStreet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.city);
        hash = 79 * hash + Objects.hashCode(this.state);
        hash = 79 * hash + Objects.hashCode(this.firstName);
        hash = 79 * hash + Objects.hashCode(this.lastName);
        hash = 79 * hash + Objects.hashCode(this.zip);
        hash = 79 * hash + Objects.hashCode(this.numberAndStreet);
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
        final Address other = (Address) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.zip, other.zip)) {
            return false;
        }
        if (!Objects.equals(this.numberAndStreet, other.numberAndStreet)) {
            return false;
        }
        return true;
    }

   
}
