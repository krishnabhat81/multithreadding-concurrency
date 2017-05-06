package com.concurrency.futuresNcallables;

import java.util.concurrent.Callable;

/**
 * Created by krishna1bhat on 5/6/17.
 */
public class MyCallable implements Callable<Long> {

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (long i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
