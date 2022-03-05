package com.codingzx.concurrentThread.TestThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author codingzx
 * @description 10个线程 并发实现  计算 0 ~ 10000
 * @date 2021/5/6 21:09
 */
public class Hello {

    public volatile static int sum = 0;

    public static CountDownLatch countDownLatch = new CountDownLatch(10);

    ExecutorService executors = Executors.newCachedThreadPool();


    public static class TestThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                sum += i;
//                if (i == 999) countDownLatch.countDown();
            }
            countDownLatch.countDown();
        }
    }


    public static void main(String[] args) {
        //  1 ~ 10000
        //  10 个线程
        for (int i = 0; i < 10; i++) {
            new TestThread().run();
            // 方法2 通过判断存活线程数
//            while (Thread.activeCount() > 2) {
//
//            }
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sum);

    }


}
