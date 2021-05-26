package com.codingzx.concurrentThread.cas;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author codingzx
 * @description public final int get() //获取当前的值
 * public final int getAndSet(int newValue)//获取当前的值，并设置新的值
 * public final int getAndIncrement()//获取当前的值，并自增
 * public final int getAndDecrement() //获取当前的值，并自减
 * public final int getAndAdd(int delta) //获取当前的值，并加上预期的值
 * @date 2021/5/5 10:00
 */
public class TestAtomicInteger {

    private static final int THREADS_CONUT = 20;
    public static AtomicInteger count = new AtomicInteger(0);

    public static void increase() throws InterruptedException {
//        System.out.println("当前线程" + Thread.currentThread().getName());
//        System.out.println("当前值" + count.get());
//        System.out.println("设置新值"+count.getAndSet(2));
//        System.out.println("自增" + count.decrementAndGet());
//        System.out.println("自减" + count.incrementAndGet());
//        System.out.println("设置加上数的新值"+ count.getAndAdd(2));
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        Thread.sleep(5000);

        while (Thread.activeCount() > 2) {
            System.out.println(Thread.activeCount());
            System.out.println(Thread.currentThread().getName());
            Thread.yield();
            System.out.println(findAllThreads());
        }
        System.out.println(count);
        System.out.println(count.compareAndSet(1999,3000));
        System.out.println(count.compareAndSet(2000,3000));
        System.out.println(count.get());
    }


    public static Thread[] findAllThreads() {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
        // 遍历线程组树，获取根线程组
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
        // 激活的线程数加倍
        int estimatedSize = topGroup.activeCount() * 2;
        Thread[] slacks = new Thread[estimatedSize];
        //获取根线程组的所有线程
        int actualSize = topGroup.enumerate(slacks);
        Thread[] threads = new Thread[actualSize];
        System.arraycopy(slacks, 0, threads, 0, actualSize);
        return threads;
    }


}
