package com.concurrency.thread_communication;

/**
 * Created by krishna1bhat on 5/12/17.
 */

//A java bean class on which threads will work and call wait and notify methods.

public class Message {
    private String message;

    public Message(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
