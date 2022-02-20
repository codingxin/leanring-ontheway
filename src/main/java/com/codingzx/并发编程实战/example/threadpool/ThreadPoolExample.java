package com.codingzx.并发编程实战.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author codingzx
 * @description
 * @date 2022/1/4 20:28
 */
@Slf4j
public class ThreadPoolExample {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int count = i;
            executorService2.submit(() -> {
                log.info("task:{}", count);
            });
        }
        executorService2.shutdown();

    }


}
