package com.concurrency.producer_consumer_blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by krishna1bhat on 5/11/17.
 */
//This consumer class will process on the messages from the queue
// and terminates when Exit message is received.

public class Consumer implements Runnable {
    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            Message msg;
            //take() retrieves and remove the element from the head of the queue
            //If queue is empty it waits for the element to be available.
            while((msg = queue.take()).getMessage() != "Exit"){
                Thread.sleep(10);
                System.out.println("Consumed :: " + msg.getMessage());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
