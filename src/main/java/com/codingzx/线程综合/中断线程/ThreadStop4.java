package com.codingzx.线程综合.中断线程;


public class ThreadStop4 {
    public static void main(String[] args) throws InterruptedException {
        HelloThread1 t = new HelloThread1();
        t.start();
        Thread.sleep(1);
        t.running = false; // 标志位置为false
    }
}

class HelloThread1 extends Thread {
    public volatile boolean running = true;

    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + " Start!");
        }
        System.out.println("end!");
    }
}
