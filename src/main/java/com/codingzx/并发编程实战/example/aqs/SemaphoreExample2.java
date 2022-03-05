package com.codingzx.并发编程实战.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author codingzx
 * @description
 * @date 2021/12/29 19:57
 */
@Slf4j
public class SemaphoreExample2 {


    public static Semaphore semaphore = new Semaphore(4);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            final int count = i;
            System.out.println(i);
            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    // 如果获取不到就直接抛弃
                    if (semaphore.tryAcquire()) {
                        test(count);
//                        semaphore.release();
                    } else {
//                        System.out.println(semaphore.availablePermits());
//                        System.out.println(semaphore.getQueueLength());
                    }
                } catch (Exception e) {
                    log.error("{}", e.getMessage());
                }
            });
        }
    }


    public static void test(int count) throws InterruptedException {
        log.info("第{}个", count);
//        Thread.sleep(1000);
    }
}
