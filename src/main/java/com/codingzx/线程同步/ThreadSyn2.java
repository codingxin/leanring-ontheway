package com.codingzx.线程同步;

import lombok.Synchronized;
import lombok.var;

/**
 * Syn的使用
 * 1.找出修改共享变量的线程代码块
 * 2.选择一个共享实例作为锁
 * 3.使用synchronized（lockObject）
 * 在使用synchronized的时候，不必担心抛出异常。因为无论是否有异常，都会在synchronized结束处正确释放锁：
 *
 *
 * syn的核心准则大概总结：
 * 能不加锁就不加锁。
 * 能偏向就尽量偏向。
 * 能加轻量级锁就不用重量级锁。
 *
 */
public class ThreadSyn2 {
    public static void main(String[] args) throws InterruptedException {
        var add = new AddThread2();
        var dec = new DecThread2();
        add.start();
        dec.start();
        add.join();
//        add.interrupt();
//        dec.interrupt();
        dec.join();
        System.out.println(Counter.count);  // 每次运行的结果都不一样 非线程安全
    }
}

class Counter2 {
    public static int count = 0;
    public static final Object lock = new Object();
}

class AddThread2 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (Counter2.lock) {
                Counter.count += 1;
                System.out.println(Thread.currentThread() + "+");
            }
        }
    }
}

class DecThread2 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (Counter2.lock) {
                Counter.count -= 1;
                System.out.println(Thread.currentThread() + "-");
            }
        }
    }
}
