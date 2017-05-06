package com.concurrency.futuresNcallables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by krishna1bhat on 5/6/17.
 */
public class CallableFutures {
    private static final int noThreads = 10;
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(noThreads);
        List<Future<Long>> list = new ArrayList<>();

        for (int i = 0; i < 20000; i++){
            Callable<Long> worker = new MyCallable();
            Future<Long> submit = executorService.submit(worker);
            list.add(submit);
        }

        long sum = 0;
        System.out.println(list.size());

        // now retrieve the result
        for (Future<Long> future : list){
            try {
                sum += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(sum);
        executorService.shutdown();
    }
}
