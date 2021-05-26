package com.codingzx.concurrentThread.lock;


public class TestVolatile {

    public static volatile int count = 0;


    public static void increment() {
        count++;
    }

    public static void decrement() {
        count--;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    increment();
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    decrement();
                }
            }).start();
        }

        System.out.println(count);

    }


}
