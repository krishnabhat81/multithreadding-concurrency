package com.concurrency.thread_join;

/**
 * Created by krishna1bhat on 5/12/17.
 */
public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("MyThread "+ Thread.currentThread().getName() +" is started.");

        try{
            Thread.sleep(4000);
            throw new RuntimeException();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("MyThread "+ Thread.currentThread().getName() +" Finished.");
    }
}
