package com.codingzx.并发编程实战.example;

/**
 * @author codingzx
 * @description
 *
 *
 *    volatile 线程有序性  ：  先执行 变化操作，再输出
 * @date 2021/12/26 10:13
 */
public class TestVolatile {


    private volatile static int a = 2;

    public static void main(String[] args) {
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(a);
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a--;
        }).start();





    }



}
