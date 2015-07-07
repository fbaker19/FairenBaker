/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.olympian;

/**
 *
 * @author apprentice
 */
public class Olympian {//DTO
    private Event event;
    private String country = "'Murica";
    
    public Olympian(Event event)//interface injected into olympian
    {
        this.event = event;
    }
    public String competeInEvent()
    {
        System.out.println("now competeing for "+country+ " :");
        return event.compete();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
}
