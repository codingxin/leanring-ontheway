package com.codingzx.并发编程实战.example.lock;

import com.codingzx.并发编程实战.annoations.UnThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.*;


/**
 * @author codingzx
 * @description
 * @date 2021/12/15 20:44
 */
@Slf4j
@UnThreadSafe("线程不安全")
public class LockExample3 {


    public static final Lock lock = new ReentrantLock();

    public static final Condition condition = lock.newCondition();

    public static void main(String[] args) {


        new Thread(() -> {
            try {
                log.info("wait signal");
                lock.lock();
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("get sinal");
            lock.unlock();
            log.info("thread1  end");
        }).start();

        new Thread(() -> {
            try {
                log.info("get  lock");
                lock.lock();

                Thread.sleep(1000);
                condition.signalAll();
                log.info("send signal");
                lock.unlock();
                log.info("thread2  end");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
