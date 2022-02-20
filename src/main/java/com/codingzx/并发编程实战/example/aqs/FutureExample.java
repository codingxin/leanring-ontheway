package com.codingzx.并发编程实战.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author codingzx
 * @description
 * @date 2022/1/4 19:06
 */
@Slf4j
public class FutureExample {

    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "Done";
        }
    }


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> futureResult = executorService.submit(new MyCallable());
        log.info("do something in main");
        try {
            String result = futureResult.get();
            log.info("do something in main 5 s:{}",result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


}
