/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryv3.ui;

import com.swcguild.dvdlibraryv3.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
   ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
       Controller controller = ctx.getBean( "controller", Controller.class); //jar may have benn added to POM
               controller.run();
    }
    
}
