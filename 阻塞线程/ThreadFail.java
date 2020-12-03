package com.codingzx.多线程.阻塞线程;

/**
 * 线程阻塞通常是指一个线程在执行过程中暂停，以等待某个条件的触发。而什么情况才会使得线程进入阻塞的状态呢？
 * <p>
 * 等待阻塞：运行的线程执行wait()方法，该线程会释放占用的所有资源，JVM会把该线程放入“等待池”中。进入这个状态后，
 * 是不能自动唤醒的，必须依靠其他线程调用notify()或notifyAll()方法才能被唤醒
 *
 * 同步阻塞：运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入“锁池”中
 *
 * 其他阻塞：运行的线程执行sleep()或join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。当sleep()状态超时、
 * join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态
 */
public class ThreadFail {
}
