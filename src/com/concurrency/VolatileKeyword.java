package com.concurrency;

/**
 * Created by krishna1bhat on 5/6/17.
 */

/*
* Can we make array volatile in Java?
* Yes, but only the reference which is pointing to an array, not the whole array.
*/

public class VolatileKeyword {
    //checking volatile keyword through multi threading
    volatile String[] arr = {"One", "Two", "Three"};
    String[] a = {"test"};

    public static void main(String[] args) {
        new VolatileKeyword();
    }

    VolatileKeyword(){
        Thread1 thread1Class = new Thread1();
        Thread2 thread2Class = new Thread2();

        Thread t1 = new Thread(thread1Class);
        Thread t2 = new Thread(thread2Class);

        System.out.println("Before thread start: " + arr);

        t1.start();
        //System.out.println("in= "+arr);
        t2.start();
        //System.out.println("out= "+arr);
    }

    public class Thread1 implements Runnable{

        @Override
        public void run() {
            System.out.println("inside thread one before change: "+arr);
            arr = a;
            System.out.println("inside thread two after change: "+arr);
        }
    }

    public class Thread2 implements Runnable{

        @Override
        public void run() {
            System.out.println("inside thread two before change: "+arr);
            arr = a;
            System.out.println("inside thread two after change: "+arr);
        }
    }
}
