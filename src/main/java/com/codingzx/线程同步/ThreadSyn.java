package com.codingzx.线程同步;

import lombok.var;
import org.apache.commons.math3.analysis.function.Add;

public class ThreadSyn {
    public static void main(String[] args) throws InterruptedException {
        var add = new AddThread();
        var dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);  // 每次运行的结果都不一样 非线程安全
    }
}

class Counter {
    public static int count = 0;
}

class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Counter.count += 1;
            System.out.println(Thread.currentThread()+"+");
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Counter.count -= 1;
            System.out.println(Thread.currentThread()+"-");

        }
    }
}
