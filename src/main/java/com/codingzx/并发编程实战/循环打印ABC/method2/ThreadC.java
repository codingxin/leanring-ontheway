package com.codingzx.并发编程实战.循环打印ABC.method2;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author codingzx
 * @description
 * @date 2021/12/15 20:06
 */
public class ThreadC implements Runnable {

    private AtomicInteger atomicInteger;

    public ThreadC(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
        if (atomicInteger.getAndDecrement() == 1) {
            System.out.print("C");
            atomicInteger.getAndSet(3);
        }


    }
}
