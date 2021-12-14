package com.codingzx.设计模式.创建模式.创建模式_单例模式.双重校验锁;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 15:34
 */
public class DoubleCheckSingle implements Runnable {
    private volatile static DoubleCheckSingle singleton;

    private DoubleCheckSingle() {
    }

    public static DoubleCheckSingle getSingleton() {
        if (singleton == null) {
            synchronized (DoubleCheckSingle.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckSingle();
                }
            }
        }
        return singleton;
    }


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new DoubleCheckSingle());
        }

    }


    @Override
    public void run() {
        getSingleton();
    }
}
