package com.concurrency.producer_consumer_blockingqueue;

/**
 * Created by krishna1bhat on 5/11/17.
 */
//payload or message
//Java object, will be produced by Producer and added to queue.
public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
