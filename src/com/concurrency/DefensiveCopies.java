package com.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by krishna1bhat on 5/6/17.
 */
public class DefensiveCopies {
    public static void main(String[] args){
        new DefensiveCopies();
    }

    DefensiveCopies(){
        MyList myList = new MyList();
        List<String> tmpList = new ArrayList<>();
        tmpList.add("Hello");
        tmpList.add("Hi");

        myList.setList(tmpList);

        System.out.print(myList);

        List<String> defensiveList = myList.getList();
        defensiveList.add("Bye");//this line will throw UnsupportedOperationException

        System.out.print(defensiveList);
    }

    public class MyList{
        /*
        Non-immutable data which we don't expect that this data is
        changed outside your class.
        ---- so to protect class against that we should copy data received and only return
        copies of data to calling code ----
        */

        //below example creates a copy of a list (ArrayList)
        //returns only the copy of the list

        private List<String> list = new ArrayList<>();
        public void setList(List<String> list) {
            this.list = list;
        }

        //Makes a defensive copy of the list and return it - list can not be modified
        //Provide users with "read-only" access to internal lists
        public List<String> getList() {
            return Collections.unmodifiableList(list);
        }
    }
}
