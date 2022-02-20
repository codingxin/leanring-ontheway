package com.codingzx.并发编程实战.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author codingzx
 * @description
 * @date 2022/1/4 20:28
 */
@Slf4j
public class ThreadPoolExample2 {


    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        ;

        executorService.scheduleAtFixedRate(() -> {
            log.info("ScheduledExecutorService run");
        }, 1, 3, TimeUnit.SECONDS);


//        executorService.shutdown();


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                log.info("Timer run");
            }
        }, new Date(), 5 * 1000);

//        timer.cancel();

    }


}
