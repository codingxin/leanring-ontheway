package com.codingzx.并发编程实战.example.commonconllection;


import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;


import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;


/**
 * @author codingzx
 * @description
 * @date 2021/12/15 20:44
 */
@Slf4j
public class CopyOnWriteListDemo {

    public static int clientTotal = 5000;


    public static int threadTotal = 200;


    public static volatile List<Integer> list = new CopyOnWriteArrayList<>();

    public static volatile List<Integer> list1 = Collections.synchronizedList(Lists.newArrayList());
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
        log.info("count:{}", list.size());
        executorService.shutdown();
    }


    private static void add(int count) {
        list.add(count);
    }
}
