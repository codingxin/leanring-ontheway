package com.codingzx.多线程.处理线程返回值.Callable接口实现;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
    public  static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        new Thread(task).start();
        if (!task.isDone()) {
            System.out.println("task has not finished, please wait!");
        }
        System.out.println("task return: " + task.get());

    }
}
