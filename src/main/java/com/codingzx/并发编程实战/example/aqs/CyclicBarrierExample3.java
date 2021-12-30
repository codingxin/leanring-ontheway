package com.codingzx.并发编程实战.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author codingzx
 * @description
 * @date 2021/12/29 19:49
 */
@Slf4j
public class CyclicBarrierExample3 {


    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
        log.info("当前已到达内存屏障");
    });

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
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }


    public static void race(int count) throws InterruptedException, BrokenBarrierException, TimeoutException {
        Thread.sleep(1000);
        log.info("count:{} is read", count);
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            log.error("发生BrokenBarrierException异常");
        }
        log.info("count:{} is continue", count);
    }

}
