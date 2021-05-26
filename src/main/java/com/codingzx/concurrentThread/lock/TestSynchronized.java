package com.codingzx.concurrentThread.lock;

/**
 * @author codingzx
 * @description
 * @date 2021/5/5 9:39
 */
public class TestSynchronized {
    public static int count = 0;


    public synchronized static void increment() {
        count++;
    }

    public synchronized static void decrement() {
        count--;
    }

    public String sayHello() {
        synchronized (this) {

            System.out.println("当前conunt" + count);

        }
        return "";
    }


    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    increment();
                }
            }).start();
        }

//        Thread.sleep(1000);
//
//        for (int i = 0; i < 1; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    decrement();
//                }
//            }).start();
//        }
        while (Thread.activeCount() > 1) {
            System.out.println(Thread.activeCount());
            Thread.yield();
        }
        System.out.println(count);

    }
}
