/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Diff21 {

    public int Diff21(int n) {
        int diff = 21 - n;

        if (n > 21) {
            diff = Math.abs(diff) * 2;
        } else {
            return diff;
        }
        return diff;
    }

}

//example set up for non-boolean conditional - int result = d21.Diff21(21);

//Given an int n, return the absolute value of the difference between n and 21, 
//except return double the absolute value of the difference if n is over 21. 
//
//Diff21(23) -> 4// 21-23 =-2 >>-2 doubles is 4
//Diff21(10) -> 11
//Diff21(21) -> 0 
