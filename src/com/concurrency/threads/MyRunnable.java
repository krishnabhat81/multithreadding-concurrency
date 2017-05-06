package com.concurrency.threads;

/**
 * Created by krishna1bhat on 5/6/17.
 */

/*
* Count the sum of the number from 1 to param and print result.
*/
public class MyRunnable implements Runnable {

    private final long counter;

    MyRunnable(long counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        long sum = 0;
        for(long i = 0; i < counter; i++){
            sum += i;
        }

        System.out.println("Sum is: " + sum);
    }
}
