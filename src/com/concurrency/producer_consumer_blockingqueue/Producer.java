package com.concurrency.producer_consumer_blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by krishna1bhat on 5/11/17.
 */

//Producer class that will create messages and put it in the queue.

public class Producer implements Runnable {

    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        //produce messages
        for(int i = 0; i < 100; i++){
            Message msg = new Message("Message " + i);
            try{
                Thread.sleep(i);
                queue.put(msg);
                System.out.println("Produced :: " + msg.getMessage());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        //add Exit message
        Message msg = new Message("Exit");
        try {
            //put() method is used to insert elements to the queue
            //If the queue is full, it waits for the space to be available.
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
