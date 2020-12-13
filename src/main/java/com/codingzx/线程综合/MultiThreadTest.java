package com.codingzx.线程综合;

/**
 * @author created by zhangxin27695
 * @Classname MultiThreadTest
 * @Description
 * @Date 2020-07-28 20:41
 */
/**
 * 线程轮流打印1,2,3,4和a,b,c,d
 */
public class MultiThreadTest {
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(new NumberRunnable(o)).start();
        new Thread(new CharRunnable(o)).start();
    }
}

class NumberRunnable implements Runnable {
    private Object obj;//声明一个类的引用

    //通过构造器将共享资源传进来
    public NumberRunnable(Object obj) {
        this.obj = obj;
    }

    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 4; i++) {
                System.out.println(i + 1);
                obj.notifyAll();
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class CharRunnable implements Runnable {
    private Object obj;//声明一个类的引用

    //通过构造器将共享资源传进来
    public CharRunnable(Object obj) {
        this.obj = obj;
    }

    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 4; i++) {
                char ch = (char) ('a' + i);
                System.out.println(ch);
                obj.notifyAll();
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
