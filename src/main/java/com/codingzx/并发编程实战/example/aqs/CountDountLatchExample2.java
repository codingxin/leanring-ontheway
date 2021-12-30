package com.codingzx.并发编程实战.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author codingzx
 * @description
 * @date 2021/12/29 19:49
 */
@Slf4j
public class CountDountLatchExample2 {


    public static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            final int count = i;
            countDownLatch.countDown();
            executorService.execute(() -> {
                test(count);
            });
        }
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        log.info("count1");
    }


    public static void test(int count) {
        log.info("count:{}", count);
    }

}
