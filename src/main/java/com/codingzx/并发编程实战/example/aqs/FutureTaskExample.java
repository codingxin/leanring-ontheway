package com.codingzx.并发编程实战.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author codingzx
 * @description
 * @date 2022/1/4 19:06
 */
@Slf4j
public class FutureTaskExample {


    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("do something in callable");
                Thread.sleep(5000);
                return "Done";
            }
        });

        executorService.submit(futureTask);
        log.info("do something in main");
        Thread.sleep(1000);
        String result = null;
        try {
            result = futureTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        log.info("do something in main 5 s:{}", result);
    }


}
