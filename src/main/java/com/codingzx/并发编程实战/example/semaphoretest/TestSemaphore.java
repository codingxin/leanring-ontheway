package com.codingzx.并发编程实战.example.semaphoretest;

import java.util.concurrent.Semaphore;

/**
 * @author codingzx
 * @description
 * @date 2021/12/26 16:09
 */
public class TestSemaphore {

    /**
     * 5张桌子   8个人吃饭
     * 吃完一个人 新进来一个
     *
     * @param args
     */
    public static void main(String[] args) {
        int tableSize = RestrantPojo.tablesize;
        RestrantPojo restrantPojo = new RestrantPojo();
        Semaphore semaphore = new Semaphore(tableSize);
        for (int i = 0; i < 8; i++) {
            final int tableNo = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    restrantPojo.setTable(tableNo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    restrantPojo.releaseTable(tableNo);
                }

            }).start();
//            System.out.println("第" + i + "次：" + Thread.activeCount());
        }


    }

}
