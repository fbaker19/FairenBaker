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
                   //property & name (app context)
    private String country = "'Murica";
    private String sandwich = "turkey";

    public String getSandwich() {
        return sandwich;
    }

    public void setSandwich(String sandwich) {
        this.sandwich = sandwich;
    }
    
    public Olympian(Event event)//interface injected into olympian
    {
        this.event = event;//constructor takes  parameter(Event)
    }
    public String competeInEvent()
    {
        System.out.println("now competeing for "+country+ " eating sandwich  :" + sandwich);
        return event.compete();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
}
