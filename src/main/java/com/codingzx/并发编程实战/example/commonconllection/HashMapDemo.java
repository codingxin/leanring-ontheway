package com.codingzx.并发编程实战.example.commonconllection;

import com.codingzx.并发编程实战.annoations.UnThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;


/**
 * @author codingzx
 * @description
 * @date 2021/12/15 20:44
 */
@Slf4j
@UnThreadSafe("线程不安全")
public class HashMapDemo {

    public static int clientTotal = 5000;


    public static int threadTotal = 200;


    public static volatile int count = 0;


    public static Map map = new HashMap<>();

    public static Map concurrentHashMap = new ConcurrentHashMap();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        // 信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        //
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add(count);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            countDownLatch.countDown();
        }
        countDownLatch.await();
        log.info("count:{}", map.size());
        executorService.shutdown();
    }


    private static void add(int count) {
        map.put(count, 1);
    }
}
