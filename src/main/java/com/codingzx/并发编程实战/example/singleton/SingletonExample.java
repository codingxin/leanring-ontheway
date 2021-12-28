package com.codingzx.并发编程实战.example.singleton;

import com.codingzx.并发编程实战.annoations.ThreadSafe;
import com.codingzx.并发编程实战.annoations.UnThreadSafe;

/**
 * @author codingzx
 * @description   懒汉模式  在线程使用的时候创建
 * @date 2021/12/26 10:28
 */
@UnThreadSafe
public class SingletonExample {

    // 私有构造方法
    private SingletonExample() {

    }

    //  单例对象
    private static SingletonExample instance = null;

    // 静态工程方法
    // 多线程不安全，不同线程都可能同时执行
    //  synchronized 实现线程安全
    //  private static SingletonExample getInstance() {
    private static synchronized SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }


}
