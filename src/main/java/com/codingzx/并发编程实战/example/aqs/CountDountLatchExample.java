package com.codingzx.并发编程实战.example.aqs;

import com.codingzx.leetcode.company.腾讯.test;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author codingzx
 * @description
 * @date 2021/12/29 19:49
 */
@Slf4j
public class CountDountLatchExample {


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
        countDownLatch.await();
        executorService.shutdown();
        log.info("count1");
    }


    public static void test(int count) {
        log.info("count:{}", count);
    }

}
