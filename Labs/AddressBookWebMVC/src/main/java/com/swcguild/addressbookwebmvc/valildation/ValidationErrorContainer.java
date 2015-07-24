/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookwebmvc.valildation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class ValidationErrorContainer {

    private List<ValidationError> valError = new ArrayList<>();

    
    //method with parameters - you must provide 2 parameters when called
    public void addValidationError(String field, String message) {
        ValidationError error = new ValidationError(field, message);
        valError.add(error);
    }

    public List<ValidationError> getFieldErrors() {
        return valError;
    }
}
