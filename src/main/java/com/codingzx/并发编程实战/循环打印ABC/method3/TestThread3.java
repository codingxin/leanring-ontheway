package com.codingzx.并发编程实战.循环打印ABC.method3;

import com.codingzx.并发编程实战.循环打印ABC.ThreadDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author codingzx
 * @description
 * @date 2021/12/15 20:16
 */
public class TestThread3 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);


        while (true) {
            Thread athread = new Thread(new ThreadDemo("A"));
            athread.start();
            Thread.sleep(100);
            countDownLatch.countDown();

            Thread bthread = new Thread(new ThreadDemo("B"));
            bthread.start();
            Thread.sleep(100);
            countDownLatch.countDown();

            Thread cthread = new Thread(new ThreadDemo("C"));
            cthread.start();
            Thread.sleep(100);
            countDownLatch.await();
        }



    }


}
