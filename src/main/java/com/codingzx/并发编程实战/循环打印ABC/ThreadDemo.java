package com.codingzx.并发编程实战.循环打印ABC;

/**
 * @author codingzx
 * @description
 * @date 2021/12/15 19:58
 */
public class ThreadDemo implements Runnable {

    private String name;


    public ThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.print(name);
    }
}
