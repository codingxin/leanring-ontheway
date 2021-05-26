package com.codingzx.concurrentThread;

import lombok.Synchronized;

/**
 * @author codingzx
 * @description
 * @date 2021/5/5 14:35
 */
public class Singleton {

    private volatile static Singleton singleton;

    public Singleton() {

    }

    public Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                return singleton = new Singleton();
            }
        }
        return singleton;
    }


}
