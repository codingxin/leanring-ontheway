package com.codingzx.线程综合.中断线程;

/**
 * interrupt: 其作用是中断此线程（此线程不一定是当前线程，而是指调用该方法的Thread实例所代表的线程），
 * 但实际上只是给线程设置一个中断标志，线程仍会继续运行。
 * <p>
 * interrupted:作用是测试 当前 线程是否被中断（检查中断标志），返回一个boolean并清除中断状态，
 * 第二次再调用时中断状态已经被清除，将返回一个false。
 * 当前线程小心区分是main线程还是此线程
 * <p>
 * isInterrupted（）方法 作用是只测试 此线程是否被中断 ，不清除中断状态。
 *
 * 对目标线程调用interrupt()方法可以请求中断一个线程，目标线程通过检测isInterrupted()标志获取自身是否已中断。
 * 如果目标线程处于等待状态，该线程会捕获到InterruptedException；
 *
 * 目标线程检测到isInterrupted()为true或者捕获了InterruptedException都应该立刻结束自身线程；
 * 通过标志位判断需要正确使用volatile关键字；
 *
 * volatile关键字解决了共享变量在线程间的可见性问题。
 *
 */
public class ThreadStop {


    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1); // 暂停1毫秒
        t.interrupt(); // 中断t线程(设置线程中断标志，线程继续执行)
        t.join(); // 等待t线程结束
        System.out.println("end");


//        MyThread thread=new MyThread();
//        thread.start();
//        thread.interrupt();
//        System.out.println("第一次调用thread.isInterrupted()："+thread.isInterrupted()); true
//        System.out.println("第二次调用thread.isInterrupted()："+thread.isInterrupted()); true
//        //测试interrupted（）函数
//        System.out.println("第一次调用thread.interrupted()："+thread.interrupted());   false  这里是判断main线程
//        System.out.println("第二次调用thread.interrupted()："+thread.interrupted());   false   也是判断main线程
//        System.out.println("thread是否存活："+thread.isAlive());


        MyThread2 t2 = new MyThread2();
        t2.start();
        Thread.sleep(1);
        t2.running = false;

    }
}

class MyThread extends Thread {
    public void run() {
        int n = 0;
        while (!isInterrupted()) {  // 当线程中断标志为true 不满足 退出循环，实现中短线程
            n++;
            System.out.println(n + " Start!");
        }
    }
}

/**
 * 通过标志位中断
 */
class MyThread2 extends Thread {
    // 线程间共享变量需要使用volatile关键字标记，确保每个线程都能读取到更新后的变量值
    public volatile boolean running = true;

    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + " Start!");
        }
        System.out.println("end!");

    }


}