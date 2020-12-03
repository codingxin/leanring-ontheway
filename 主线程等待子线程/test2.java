package com.codingzx.多线程.主线程等待子线程;

import java.util.concurrent.CountDownLatch;

/**
 * @author created by zhangxin27695
 * @Classname test2
 * @Description
 * join()：等待该线程结束，后面的语句一定会等待该线程结束才执行，该方法有三个有两个有参的重载方法
 *
 * join(long millis)：等待该线程millis 毫秒，不管该线程是否执行结束，后面的语句都开始执行
 *
 * join(long millis, int nanos)：等待该线程millis+nanos 毫秒，不管该线程是否执行结束，后面的语句都开始执行
 *
 * 后面两个方法是不一定等待该线程执行完的。
 * @Date 2020-07-29 15:57
 */
public class test2 {

    public static void main(String[] args) {

        ThreadDemoJ threadDemoJ = new ThreadDemoJ();
        try {
            Thread thread1 = new Thread(threadDemoJ);
            Thread thread2 = new Thread(threadDemoJ);
            Thread thread3 = new Thread(threadDemoJ);

            thread1.start();
            thread2.start();
            thread3.start();
            //让三个线程执行完，如果在调用start方法后面直接调用join方法，那么三个线程将串行

            thread1.join();
            thread2.join();
            thread3.join();


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("执行结束到主线程");
    }

    static class ThreadDemoJ implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "执行");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
