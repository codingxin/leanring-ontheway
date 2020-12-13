package com.codingzx.线程综合.多线程.Thread测试.线程创建;

/**
 * @author created by zhangxin27695
 * @Classname Threadextends
 * @Description
 * @Date 2020-05-11 16:50
 */
public class Threadextends {
    public static void main(String[] args) {
        SomeThead oneThread = new SomeThead();
        oneThread.start();

        new Thread(){
            public void run(){
                System.out.println("thread1 start ... ");
            }
        }.start();


        new Thread(()-> {
            for(int i = 1 ; i<100 ; i++){
                System.out.println("It is a lambda function!");
            }

        }).start();

    }
}
class SomeThead extends Thread
{
    public void run()
    {
        System.out.println("通过继承Thread类来创建一个线程"+System.currentTimeMillis());
    }
}
