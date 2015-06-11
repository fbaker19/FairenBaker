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
public class SameFirstLast {

    public boolean SameFirstLast(int[] numbers) {

        if (numbers[0] == 1 && numbers[numbers.length - 1] == 1)
        {
            return true;
        }else{ 
                return false; 
              }
      }
}