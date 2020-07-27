package com.codingzx.leetcode.leetcode.多线程;

import java.util.concurrent.CountDownLatch;

/**
 * @author created by zhangxin27695
 * @Classname _1114按序打印
 * @Description
 * @Date 2019-11-20 15:44
 */
public class _1114按序打印 {

//    public Semaphore seam_first_two = new Semaphore(2);
//    //同步关键类，构造方法传入的数字是多少，则同一个时刻，只运行多少个进程同时运行制定代码
//
//    public Semaphore seam_two_second = new Semaphore(2);
    private CountDownLatch second = new CountDownLatch(2);
    private CountDownLatch third = new CountDownLatch(2);
    public _1114按序打印() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
//        printFirst.run();
//        seam_first_two.release();
           printFirst.run();
                second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
//        seam_first_two.acquire();
//        printSecond.run();
//        seam_two_second.release();

           second.await();
                printSecond.run();
                third.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
//        seam_two_second.acquire();
//        printThird.run();


                third.await();
                printThird.run();
    }
    public static void main(String[] args) {
        _1114按序打印 _1114按序打印 = new _1114按序打印();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    _1114按序打印.first(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(1);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    _1114按序打印.second(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(2);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    _1114按序打印.third(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(3);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();
        t2.start();
        t1.start();
    }

}
