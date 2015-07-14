/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevenwebapp.model;

/**
 *
 * @author apprentice
 */
public class Luck {//DTO/Model for every DTO there Needs to be a jsp file (each jsp file is a different page)
    public int dollars;

    public long getDollars() {
        return dollars;
    }

    public void setDollars(int choice) {
        this.dollars = choice;
    }
    public String result;
       public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
