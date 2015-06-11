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
public class SleepIn {

    public boolean CanSleepIn(boolean isWeekday, boolean isVacation) {
        if (!isWeekday || !isVacation)//weekend
        {
            return true;
        } else if (isWeekday || !isVacation) {
            return false;
        } else {
            return true;
        }

    }

}
