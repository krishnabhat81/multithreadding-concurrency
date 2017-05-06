package com.concurrency.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by krishna1bhat on 5/6/17.
 */
//Thread pool --- Collection of Runnable objects (work queue)
//Threads pools with the Executor Framework
//Thread pools manage a pool of worker threads
//The thread pools contains a work queue which holds tasks waiting to get executed.
public class Main {
    public static void main(String[] args){
        //List<Thread> threads = new ArrayList<>();

        //creating 500 threads
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 500; i++) {
            Runnable worker = new MyRunnable(10000000L + i);
            executor.execute(worker);
        }
        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();
        // Wait until all threads are finish
        //executor.awaitTermination();
        System.out.println("Finished all threads");
    }
}

// -------- NOTE ---------
// Thread class itself provides a method, e.g. execute(Runnable r)
// to add a new Runnable object to the work queue.

//Executors.newSingleThreadExecutor() ---->> If you want to use one thread pool with one thread which executes several runnables

// ----------- In case the threads should return some value ----------
// Use the java.util.concurrent.Callable class
// Refer to com.concurrency.futuresNcallables package in this application