package com.codingzx.线程综合.多线程.主线程等待子线程;

import java.util.concurrent.CountDownLatch;

/**
 * @author created by zhangxin27695
 * @Classname test1
 * @Description 让多个子线程执行完再执行主线程的三种实现方式
 * @Date 2020-07-29 15:47
 */
public class test1 {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(10);
        LatchDemo ld = new LatchDemo(latch);
        for (int i = 0; i < 10; i++) {
            new Thread(ld).start();
        }
        try {
            latch.await();  // 让主线程等待多个执行完后再执行
        } catch (InterruptedException e) {

        }
        System.out.println("主线程执行");

    }

    static class LatchDemo implements Runnable {
        // 多线程需共享latch
        private CountDownLatch latch;

        public LatchDemo(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "执行结束");
            latch.countDown();
        }
    }
}
