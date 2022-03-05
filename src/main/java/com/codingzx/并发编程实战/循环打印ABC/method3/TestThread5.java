package com.codingzx.并发编程实战.循环打印ABC.method3;

import com.codingzx.并发编程实战.循环打印ABC.ThreadDemo;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author codingzx
 * @description
 * @date 2021/12/15 20:16
 */
@Slf4j
public class TestThread5 {

    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(1, () -> {
//        log.info("当前已到达内存屏障");
    });

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {


        while (true) {
            new Thread(() -> {
                try{
                    System.out.print("A");
                    Thread.sleep(1);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try{
                    Thread.sleep(1);
                    System.out.print("B");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try{
                    System.out.print("C");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
//            cyclicBarrier.reset();
        }


    }


}
