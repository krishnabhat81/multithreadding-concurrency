package com.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna1bhat on 5/6/17.
 */

//only one thread can access the inner block of add() and next() methods
public class BlockSynchronized {
    private List<String> updatedList = new ArrayList<>();
    private List<String> addedList = new ArrayList<>();

    public void add(String item){
        synchronized (this){
            if(!updatedList.contains(item)){
                addedList.add(item);
            }
        }
    }

    public String get(){
        if(addedList.size() == 0) return  null;
        synchronized (this){
            if(addedList.size() > 0){
                String str = addedList.get(0);
                addedList.remove(0);
                updatedList.add(str);
                return str;
            }
            return null;
        }
    }
}
