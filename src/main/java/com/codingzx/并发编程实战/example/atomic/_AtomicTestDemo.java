package com.codingzx.并发编程实战.example.atomic;

import com.codingzx.并发编程实战.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author codingzx
 * @description
 * @date 2021/12/15 20:44
 */
@Slf4j
@ThreadSafe
public class _AtomicTestDemo {

    public static int clientTotal = 5000;


    public static int threadTotal = 200;


    public static AtomicInteger count = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        // emaphore（信号量）是用来控制同时访问特定资源的线程数量，它通过协调各个线程，以保证合理的使用公共资源
        final Semaphore semaphore = new Semaphore(threadTotal);
        //
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            countDownLatch.countDown();
        }
        countDownLatch.await();
        log.info("count:{}", count);
        executorService.shutdown();
    }


    private static void add() {
        count.incrementAndGet();
    }
}
