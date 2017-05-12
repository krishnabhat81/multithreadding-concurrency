package com.concurrency.thread_join;

import com.concurrency.threadpools.MyRunnable;

/**
 * Created by krishna1bhat on 5/12/17.
 */

//Java Thread join method can be used to pause the current thread execution
// until unless the specified thread is dead.
public class MainTest {
    public static void main(String[] args){
        Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("UncaughtException: " + e);
            }
        };

        Thread t1 = new Thread(new MyThread(), "t1");
        Thread t2 = new Thread(new MyThread(), "t2");
        Thread t3 = new Thread(new MyThread(), "t3");

        t1.setUncaughtExceptionHandler(h);//handle exception thrown by thread in main
        t1.start();

        //start second thread after waiting for 2 seconds or if it's dead
        try {
            System.out.println("Here0");//in main thread
            t1.join(2000);//pause current thread (main) for 2 sec(or t1 dead) and run main again...
            System.out.println("Here");//in main thread
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Here1");//in main thread
        t2.start();
        System.out.println("Here2");//in main thread
        //start third thread only when first thread is dead
        try{
            t1.join();//pause the current(main) thread execution until unless the t1 thread is dead
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        t3.start();

        //let all threads finish execution before finishing main thread
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads are dead, exiting main thread.");
        //NOTE: try removing all joins, this last will print first(i.e. main thread exits first then other...)
        //if any error/exception occurs in any thread, that thread will terminate, all other will run continuously until dead
        //try writing one more time t1.start(); somewhere in this program -- we can start thread only once
    }
}
