package com.codingzx.并发编程实战.example.commonconllection;

import com.codingzx.并发编程实战.annoations.UnThreadSafe;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


/**
 * @author codingzx
 * @description
 * @date 2021/12/15 20:44
 */
@Slf4j
@UnThreadSafe("线程不安全")
public class ArrayListDemo {

    public static int clientTotal = 5000;


    public static int threadTotal = 200;


    public static volatile int count = 0;


    public static volatile List<Integer> list = new ArrayList<>();

    public static volatile Vector<Integer> vectorList = new Vector<>();

    public static volatile List<Integer> safeList = Collections.synchronizedList(Lists.newArrayList());

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
        log.info("count:{}", safeList.size());
        executorService.shutdown();
    }


    private static void add(int count) {
        safeList.add(count);
    }
}
