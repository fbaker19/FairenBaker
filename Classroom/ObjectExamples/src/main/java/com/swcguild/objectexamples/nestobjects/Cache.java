package com.swcguild.objectexamples.nestobjects;

public class Cache {

    public static class CacheEntry //stores cache entries
    {

        public long timeInserted = 0;
        public Object value = null;

    }

    private CacheEntry[] entries; //private is only accesible to the class it is in
    private int index = 0;

    public Cache(int size)// size of array 
    {
        entries = new CacheEntry[size]; //makes reference place holders --->. array of cache entries 
    }                                  // field ==> array

    public int store(Object value) {
        CacheEntry entry = new CacheEntry();
        entry.timeInserted = System.currentTimeMillis();
        entry.value = value;
        entries[index] = entry;//made cache entry on the heap ==> heap is reference top other classes (memory application)
        return ++index;
    }

    public Object get(int i) {
        if (index < entries.length && index >= 0) {
            return entries[i].value;
        }

        return null;
    }

    public CacheEntry getCacheEntry(int i) {
        if (index < entries.length && index >= 0) {
            return entries[i];
        }

        return null;
    }


public void retire() {
        for (int i = 0; i < entries.length; i++) 
            {
            if (entries[i] != null && entries[i].timeInserted - System.currentTimeMillis() 
                 > 60000)
            {
           entries[i] = null;
            }
        }

    }

}

