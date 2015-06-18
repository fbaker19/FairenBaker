/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class NearHundred {

    public boolean NearHundred(int n) {
        int value1 = 100 - n;
        int value2 = 200 - n;
        if (Math.abs(value1) <= 10 || Math.abs(value2) <= 10) {

            return true;
        } else {
            return false;
        }
    }
}

//Given an int n, return true if it is within 10 of 100 or 200.
//Hint: Check out the C# Math class for absolute value
//
//NearHundred(103) -> true
//NearHundred(90) -> true
//NearHundred(89) -> false
