package com.codingzx.并发编程实战.循环打印ABC.method4;

import com.codingzx.并发编程实战.循环打印ABC.ThreadDemo;
import org.apache.catalina.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author codingzx
 * @description 线程池实现
 * @date 2021/12/15 20:22
 */
public class TestThread4 {

    // 单线程实现
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    // 定时任务单线程
    private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);


    public static void main(String[] args) {
//        method1();
        method2();
    }


    public static void method1() {
        while (true) {
            executorService.submit(new ThreadDemo("A"));
            executorService.submit(new ThreadDemo("B"));
            executorService.submit(new ThreadDemo("C"));
        }
    }

    public static void method2() {
        scheduledExecutorService.scheduleAtFixedRate(new ThreadDemo("A"), 0, 3, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new ThreadDemo("B"), 1, 3, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new ThreadDemo("C"), 2, 3, TimeUnit.MILLISECONDS);
    }





}
