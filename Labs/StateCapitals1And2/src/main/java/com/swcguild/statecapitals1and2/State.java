/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.statecapitals1and2;

/**
 *
 * @author apprentice
 */
public class State {
    
    private int population = 0;
    private int sqMileage = 0;
    private String capital;
    private String name;

    
    public State(int population, int sqMileage, String capital,  String name)
    {
        this.population = population;
        this.sqMileage = sqMileage;
        this.name = name;
        this.capital = capital;
    }
    
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getSqMileage() {
        return sqMileage;
    }

    public void setSqMileage(int sqMileage) {
        this.sqMileage = sqMileage;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
