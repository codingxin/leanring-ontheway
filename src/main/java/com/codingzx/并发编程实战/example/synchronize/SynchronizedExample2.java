package com.codingzx.并发编程实战.example.synchronize;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author codingzx
 * @description
 * @date 2021/12/21 20:47
 */
@Slf4j
public class SynchronizedExample2 {




    // 修饰静态方法  作用于整个类
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("Test 2: {},{}",j,i);
        }
    }


    public static void main(String[] args) {
        SynchronizedExample2 synchronizedExample1=new SynchronizedExample2();
        SynchronizedExample2 synchronizedExample2=new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(()->{
            synchronizedExample1.test2(1);
        });
        executorService.submit(()->{
            synchronizedExample2.test2(2);
        });
    }


}
