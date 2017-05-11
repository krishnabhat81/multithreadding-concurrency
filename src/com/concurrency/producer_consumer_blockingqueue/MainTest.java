package com.concurrency.producer_consumer_blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by krishna1bhat on 5/11/17.
 */

//Create and test producer and consumers...
//Create the BlockingQueue with fixed size and share with both producers and consumers
//Java BlockingQueue implementations are thread-safe
    
public class MainTest {
    public static void main(String[] args) {

        //Creating BlockingQueue of size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        //starting producer to produce messages in queue
        new Thread(producer).start();

        //starting consumer to consume messages from queue
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started...");
    }
}
