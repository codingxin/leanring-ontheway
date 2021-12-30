package com.codingzx.并发编程实战.example.lock;

import com.codingzx.concurrentThread.aqs.TestReetranReadWriteLock;
import com.codingzx.并发编程实战.annoations.UnThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;


/**
 * @author codingzx
 * @description
 * @date 2021/12/15 20:44
 */
@Slf4j
@UnThreadSafe("线程不安全")
public class LockExample2 {

    public static int clientTotal = 5000;


    public static int threadTotal = 200;


    public static volatile int count = 0;


    private final static Lock lock = new ReentrantLock();

    private final static ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();

    private final static Lock readLock = lock1.readLock();

    private final static Lock writeLock = lock1.readLock();

    private final static StampedLock lock2 = new StampedLock();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        // 信号量
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
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
