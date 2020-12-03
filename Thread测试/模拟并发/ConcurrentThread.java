package com.codingzx.多线程.Thread测试.模拟并发;

public class ConcurrentThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + "main start...");
        Thread t = new Thread() {
            public void run() {
                System.out.println(Thread.currentThread() + "thread run...");
                try {
                    Thread.sleep(10); //暂停10ms
                } catch (InterruptedException e) {
                    System.out.println("thread interrupt");
                }
                System.out.println(Thread.currentThread() + "thread end.");
            }
        };
//        t.setPriority(0); //设置优先级1-10，默认5
        t.start(); // start 调用本地方法start0 当线程状态为0时新建线程
        System.out.println(Thread.currentThread() + "main end...");
    }
}
