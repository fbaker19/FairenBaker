/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvd3maven;

import com.swcguild.dvd3maven.dto.LibraryLambda;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 *
 * @author apprentice
 */
public class DvdMavenApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        LibraryLambda maven = ctx.getBean("releaseDate",LibraryLambda.class );
    }
    
}
