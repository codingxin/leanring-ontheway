package com.codingzx.多线程.Thread测试.线程创建;

/**
 * @author created by zhangxin27695
 * @Classname Runnableimplements
 * @Description 实现Runnable接口比继承Thread类所具有的优势：
 * 适合多个相同的程序代码的线程去共享同一个资源。
 * 可以避免java中的单继承的局限性。
 * 增加程序的健壮性，实现解耦操作，代码可以被多个线程共享，代码和线程独立。
 * 线程池只能放入实现Runable或Callable类线程，不能直接放入继承Thread的类。
 * @Date 2020-05-11 16:44
 */
public class Runnableimplements {
    public static void main(String[] args) {
        // 1
//        SomeRunnable runnable = new SomeRunnable();
//        Thread crethread = new Thread(runnable);
//        crethread.start();
//
//
//        // 2
//        Runnable runable1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("通过实现Runnable接口来创建Thread线程" + System.currentTimeMillis());
//            }
//        };
//        new Thread(runable1).start();
//
//        // 3
//        new Thread(new SomeRunnable() {
//            @Override
//            public void run() {
//                System.out.println("通过实现Runnable接口的匿名内部类来创建Thread线程 .... ");
//            }
//        }).start();
//
//
//        // 实现Runnable方法
//        new Thread(() -> {
//            for (int i = 1; i < 100; i++) {
//                System.out.println("It is a lambda function!");
//            }
//
//        }).start();

/**
 * Thread实现了Runable方法（重写了run方法），如果Thread有run方法则调用Thread的run方法
 */
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 100; x++) {
                    System.out.println(Thread.currentThread() + "--" + x);
                }

            }
        }) {
            public void run() {
                for (int x = 0; x < 100; x++) {
                    System.out.println(Thread.currentThread() + "--" + x);
                }
            }
        }.start();


    }
}

class SomeRunnable implements Runnable {
    public void run() {
        System.out.println("通过实现Runnable接口的来创建Thread线程" + System.currentTimeMillis());
    }
}
