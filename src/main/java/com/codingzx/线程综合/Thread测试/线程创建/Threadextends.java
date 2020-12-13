package com.codingzx.线程综合.Thread测试.线程创建;

/**
 * @author created by zhangxin27695
 * @Classname Threadextends
 * @Description
 * @Date 2020-05-11 16:50
 */
public class Threadextends {
    public static void main(String[] args) {
        // 创建一个新线程
        SomeThead oneThread = new SomeThead();
        // 启动线程
        oneThread.start();  // 注意到start()方法会在内部自动调用实例的run()方法。

        new Thread() {
            public void run() {
                System.out.println("thread1 start ... ");
            }
        }.start();



    }
}

class SomeThead extends Thread {
    public void run() {
        System.out.println("通过继承Thread类来创建一个线程" + System.currentTimeMillis());
    }
}
