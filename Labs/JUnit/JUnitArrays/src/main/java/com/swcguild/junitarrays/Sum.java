/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.junitarrays;

/**
 *
 * @author apprentice
 */
public class Sum {

    public int Sum(int[] numbers) {
        if (numbers.length >= 3) {
            return (numbers[0] + numbers[1] + numbers[2]);
        } else {
            return 0;
        }

    }

}
