package com.codingzx.review.ABC交差打印;

/**
 * @author codingzx
 * @description
 * @date 2021/12/14 20:01
 */
public class ThreadDemo implements Runnable {

    // 前一个线程的锁
    private final Object preLock;

    // 当前线程的锁
    private final Object curLock;

    // 打印的字符串
    private final String printStr;


    public ThreadDemo(Object preLock, Object curLock, String printStr) {
        this.preLock = preLock;
        this.curLock = curLock;
        this.printStr = printStr;
    }


    public static void main(String[] args) throws InterruptedException {
        //打印A的锁
        Object objectA = new Object();
        //打印B的锁
        Object objectB = new Object();
        //打印C的锁
        Object objectC = new Object();


        Thread threadA = new Thread(new ThreadDemo(objectC, objectA, "A"));

        Thread threadB = new Thread(new ThreadDemo(objectA, objectB, "B"));

        Thread threadC = new Thread(new ThreadDemo(objectB, objectC, "C"));


        // 依次开启A B C 线程
        threadA.start();
        Thread.sleep(100);
        threadB.start();
        Thread.sleep(100);
        threadC.start();
        Thread.sleep(100);


    }


    @Override
    public void run() {
        while (true) {
            synchronized (preLock) {
                synchronized (curLock) {
                    System.out.println(printStr);
                    // notify 和 notifyall都行 因为只有一个线程在等待
                    curLock.notify();
                }
            }
        }
    }


}
