package com.concurrency.thread_communication;

/**
 * Created by krishna1bhat on 5/12/17.
 */
//wait for other threads to invoke notify methods to complete it’s processing
//Notice: synchronized block on Message object

public class Waiter implements Runnable {
    private Message message;

    public Waiter(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (message) {
            try{
                System.out.println(name+" waiting to get notified at time:"+System.currentTimeMillis());
                message.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name+" waiter thread got notified at time:"+System.currentTimeMillis());
            //process the message now
            System.out.println(name+" processed: " + message.getMessage());
        }
    }
}