/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.olympian;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SkiJumper sj = ctx.getBean("superSkiJumper", SkiJumper.class);// calls Spring "superSkiJumper" &  SkiJumper class
        sj.competeInEvent();

        Event skiJumpEvent = new SkiJumpEvent();
        Olympian olympianSkiJumper = new Olympian(skiJumpEvent);
        olympianSkiJumper.competeInEvent();

        System.out.println("--------------===============================-----------");
        Olympian usaSkiJumper = ctx.getBean("usaSkiJumper", Olympian.class);//calls file(appContext) & (Olympian)class
        usaSkiJumper.competeInEvent();

        Olympian usaSpeedSkater = ctx.getBean("usaSpeedSkater", Olympian.class);
        usaSpeedSkater.competeInEvent();

        Olympian canadianSpeedSkater = ctx.getBean("canadianSpeedSkater", Olympian.class);
        canadianSpeedSkater.competeInEvent();//"canada is set in the applicationContext via beans property
//            ie.)
//        <bean id="canadianSpeedSkater" class="com.swcguild.olympian.Olympian">
//              <constructor-arg ref = "speedSkating"/>
//              <property name = "country" value = "Canada"/>
//        </bean>
//    
    }
}
