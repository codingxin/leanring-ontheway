package com.codingzx.线程综合.多线程.处理线程返回值.Callable接口实现;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception{
        String value="主线程实现";
        System.out.println("Ready to work");
        Thread.currentThread().sleep(5000);
        System.out.println("task done");
        return  value;
    }

}