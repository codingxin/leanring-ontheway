package com.codingzx.并发编程实战.循环打印ABC.method2;

import com.codingzx.并发编程实战.循环打印ABC.ThreadDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author codingzx
 * @description
 * @date 2021/12/15 20:09
 */
public class TestThread2 {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger=new AtomicInteger(3);
        while (true) {
            Thread athread = new Thread(new ThreadA(atomicInteger));
            athread.start();
            Thread.sleep(100);
            Thread bthread = new Thread(new ThreadB(atomicInteger));
            bthread.start();
            Thread.sleep(100);
            Thread cthread = new Thread(new ThreadC(atomicInteger));
            cthread.start();
            Thread.sleep(100);
        }


    }

}
