package com.kxw.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by kangxiongwei on 16/6/1 下午11:25.
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        NumberOperation operation = new NumberOperation();

        ExecutorService es = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(1000);
        List<Future<Integer>> list = new ArrayList<>();
        for (int i=0; i<100; i++) {
            Future<Integer> future = es.submit(new NumberThread(latch, operation));
            list.add(future);
        }

        try {
            latch.await();
            Integer total = 0;
            for (Future<Integer> task: list) {
                try {
                    total += task.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(total);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    static class NumberThread implements Callable<Integer> {

        private NumberOperation operation;
        private CountDownLatch latch;

        public NumberThread(CountDownLatch latch, NumberOperation operation) {
            this.latch = latch;
            this.operation = operation;
        }

        @Override
        public Integer call() throws Exception {
            try {
                Thread.sleep(new Random().nextInt(5000));
                return this.operation.getI();
            } finally {
                this.latch.countDown();
            }
        }
    }

}
