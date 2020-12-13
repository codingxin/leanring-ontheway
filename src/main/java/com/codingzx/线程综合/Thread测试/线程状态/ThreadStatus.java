package com.codingzx.线程综合.Thread测试.线程状态;

/**
 * Java线程对象Thread的状态包括：New、Runnable、Blocked、Waiting、Timed Waiting和Terminated；
 * 通过对另一个线程对象调用join()方法可以等待其执行结束；
 * 可以指定等待时间，超过等待时间线程仍然没有结束就不再等待；
 *
 * 对已经运行结束的线程调用join()方法会立刻返回。
 * New：新创建的线程，尚未执行；
 * Runnable：运行中的线程，正在执行run()方法的Java代码；
 * Blocked：运行中的线程，因为某些操作被阻塞而挂起；
 * Waiting：运行中的线程，因为某些操作在等待中；
 * Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；
 * Terminated：线程已终止，因为run()方法执行完毕
 *
 * 线程终止的原因有：
 * 线程正常终止：run()方法执行到return语句返回；
 * 线程意外终止：run()方法因为未捕获的异常导致线程终止；
 * 对某个线程的Thread实例调用stop()方法强制终止（强烈不推荐使用）。
 *一个线程还可以等待另一个线程直到其运行结束。例如，main线程在启动t线程后，可以通过t.join()等待t线程结束后再继续运行：
 *
 */
public class ThreadStatus {


    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        });
        System.out.println("start");
        t.start();
        t.join();
        System.out.println("end");
    }




}
