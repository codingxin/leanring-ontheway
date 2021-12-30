package com.codingzx.并发编程实战.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

import static com.codingzx.并发编程实战.example.aqs.SemaphoreExample.test;

/**
 * @author codingzx
 * @description
 * @date 2021/12/29 19:49
 */
@Slf4j
public class CyclicBarrierExample {


    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int count = i;
            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    race(count);
                } catch (InterruptedException e) {
                    log.error("log error");
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    log.error("log error");
                    e.printStackTrace();
                }
            });
        }
    }


    public static void race(int count) throws InterruptedException, BrokenBarrierException {
        Thread.sleep(1000);
        log.info("count:{} is read", count);
        cyclicBarrier.await();
        log.info("count:{} is continue", count);
    }

}
