package com.codingzx.并发编程实战.循环打印ABC.method1;

import com.codingzx.并发编程实战.循环打印ABC.ThreadDemo;

/**
 * @author codingzx
 * @description 手动实现三个线程打印 ABC
 * @date 2021/12/15 20:01
 */
public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread athread = new Thread(new ThreadDemo("A"));
            athread.start();
            athread.join();
            Thread bthread = new Thread(new ThreadDemo("B"));
            bthread.start();
            bthread.join();
            Thread cthread = new Thread(new ThreadDemo("C"));
            cthread.start();
        }


    }


}
