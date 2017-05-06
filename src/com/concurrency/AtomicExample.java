package com.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by krishna1bhat on 5/6/17.
 */


/*
* reading or writing a variable is an atomic operation except long and double
* Use volatile keyword to the type long or double to make atomic
*
* Example below int i; then i++(increment) is not atomic operation in java
* Becoz, i++ first reads value which is stored in i(atomic) and then adds one to i (atomic)
* But in between these read/write i might be changed.
*/
public class AtomicExample {
    private int i = 0;
    public static void main(String[] args){
        new AtomicExample();
    }

    //constructor
    AtomicExample(){
        T1 t1 = new T1();
        T2 t2 = new T2();

        System.out.println("Value of i: " + i);

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);

        thread1.start();
        thread2.start();

        //Since Java 1.5, there are atomic variables like AtomicInteger, AtomicLong...
        AtomicInteger iAtomic = new AtomicInteger(0);
        iAtomic.getAndIncrement();//it is atomic
        System.out.println("iAtomic :" + iAtomic);
    }

    public class T1 implements Runnable{

        @Override
        public void run() {
            i++;
            System.out.println("inside first thread: " + i);
        }
    }

    public class T2 implements Runnable{

        @Override
        public void run() {
            i++;
            System.out.println("inside second thread: " + i);
        }
    }
}
