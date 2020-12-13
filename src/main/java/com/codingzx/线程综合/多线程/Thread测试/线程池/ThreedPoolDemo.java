package com.codingzx.线程综合.多线程.Thread测试.线程池;

import com.codingzx.线程综合.多线程.处理线程返回值.Callable接口实现.MyCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author codingzx
 * @description
 * @date 2020/8/4 21:15
 */
public class ThreedPoolDemo {
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool= Executors.newCachedThreadPool();
        Future<String> future = newCachedThreadPool.submit(new MyCallable());
        if(!future.isDone()){
            System.out.println("task has not finished, please wait!");
        }
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            newCachedThreadPool.shutdown();
        }
    }
}
