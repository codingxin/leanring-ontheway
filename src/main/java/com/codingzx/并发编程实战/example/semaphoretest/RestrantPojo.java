package com.codingzx.并发编程实战.example.semaphoretest;

import lombok.Data;

/**
 * @author codingzx
 * @description
 * @date 2021/12/26 16:05
 */
@Data
public class RestrantPojo {

    public static int tablesize = 5;

    public void setTable(int tableNo) {
        try {
            System.out.println("第" + tableNo + "桌的客人开始就餐");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            releaseTable(tableNo);
        }
    }

    public void releaseTable(int tableNo) {
        System.out.println("第" + tableNo + "桌的客人已经就餐完毕.下一桌的客人进来了");
    }


}
