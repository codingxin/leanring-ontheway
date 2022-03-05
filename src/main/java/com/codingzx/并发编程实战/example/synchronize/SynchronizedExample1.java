package com.codingzx.并发编程实战.example.synchronize;

import lombok.extern.slf4j.Slf4j;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author codingzx
 * @description
 *
 *
 *  synchronized(ClassName.class) 
 *
 *
 * @date 2021/12/21 20:47
 */
@Slf4j
public class SynchronizedExample1 {

    // 修饰代码块  作用于引用对象
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("Test 1: {},{}",j,i);
            }


        }
    }


    // 修饰方法 作用于引用对象
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("Test 2: {},{}",j,i);
        }
    }


    public static void main(String[] args) {
        SynchronizedExample1 synchronizedExample1=new SynchronizedExample1();
        SynchronizedExample1 synchronizedExample2=new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(()->{
            synchronizedExample1.test1(1);
        });
        executorService.submit(()->{
            synchronizedExample1.test2(2);
        });
    }


}
