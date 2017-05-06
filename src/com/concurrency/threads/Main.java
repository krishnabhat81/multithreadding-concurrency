package com.concurrency.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna1bhat on 5/6/17.
 */
public class Main {
    public static void main(String[] args){
        List<Thread> threads = new ArrayList<>();

        //creating 500 threads
        for(int i = 0; i < 500; i++){
            Runnable task = new MyRunnable(10000000L + i);
            Thread thread = new Thread(task);

            //set the name of thread
            thread.setName(String.valueOf(i));
            thread.start();

            // Remember the thread for later usage
            threads.add(thread);
        }

        int running = 0;

        do{
            running = 0;
            for(Thread t : threads){
                if(t.isAlive()) running++;
            }

            System.out.println("We have " + running + " running threads.");

        }while(running > 0);
    }
}


/*
* ------- NOTE ------
* 1. Creating a new thread causes some performance overhead.
* 2. Too many threads can lead to reduced performance,
*    as the CPU needs to switch between these threads.
* 3. May be out of memory errors due to too many threads.
*
* -->> The java.util.concurrent package offers improved support
*      for concurrency compared to the direct usage of Threads...
*/