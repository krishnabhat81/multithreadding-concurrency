package com.concurrency.thread_communication;

/**
 * Created by krishna1bhat on 5/12/17.
 */
//Why wait(), notify() and notifyAll() methods have to be called from synchronized method or block?

public class MainTest {
    public static void main(String[] args) {
        Message msg = new Message("process it");
        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter").start();

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();

        System.out.println("All the threads are started");
    }

}
