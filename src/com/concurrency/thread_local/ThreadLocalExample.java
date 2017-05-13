package com.concurrency.thread_local;

/**
 * Created by krishna1bhat on 5/12/17.
 */

/*
Java ThreadLocal is used to create thread-local variables.
Every thread has it’s own ThreadLocal variable and they can use it’s get() and set() methods
to get the default value or change it’s value local to Thread
 */
public class ThreadLocalExample {
    public static class MyRunnable implements Runnable {

//        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
//            @Override
//            protected Integer initialValue() {
//                return 11111;
//            }
//        };

        //Java 8, Lambda exp --- withInitial() takes Supplier functional interface
        private ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 11111);

        @Override
        public void run() {
            System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Integer value = "+threadLocal.get());

            threadLocal.set( (int) (Math.random() * 100D) );

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println("Thread Name= "+Thread.currentThread().getName()+" my Integer value = "+threadLocal.get());

        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }
}

//create daemon thread in Java?
//setDaemon(true); before t.start();
