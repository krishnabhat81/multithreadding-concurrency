package com.concurrency.ConcurrentHashMap_Example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by krishna1bhat on 5/12/17.
 */
public class ConcurrentHashMapExample {
    public static void main(String[] args){
        //HashMap
        Map<String, String> myMap = new HashMap<>();
        myMap.put("Str 1", "1");
        myMap.put("Str 2", "2");
        myMap.put("Str 3", "3");
        myMap.put("Str 4", "4");
        myMap.put("Str 5", "5");

        System.out.println("-------- HashMap before iterator ----------");
        System.out.println(myMap);

        Iterator<String> iterator1 = myMap.keySet().iterator();
        while (iterator1.hasNext()){
            String key = iterator1.next();
            if(key.equals("Str 3"))
                myMap.put("Str New 3", "New 3");
        }

        System.out.println("-------- HashMap after iterator ----------");
        System.out.println(myMap);
    }
}
