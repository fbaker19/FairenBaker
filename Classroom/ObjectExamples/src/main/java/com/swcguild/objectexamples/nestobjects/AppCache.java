/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.objectexamples.nestobjects;

import com.swcguild.objectexamples.nestobjects.Cache.CacheEntry;

/**
 *
 * @author apprentice
 */
public class AppCache {
    
    public static void main(String[] args) {
        
        Cache cache = new Cache (20);
        
        for(int i=0; i<15;i++)
        {
        cache.store(new Integer (i*2));
        }
           
        for(int i=0; i<15;i++) {
            System.out.println(cache.get(i));
        }
        
        CacheEntry entry = new CacheEntry();// make cache public& static in other class 
                                            //& inmport Cache entry
        
    }
    
}
