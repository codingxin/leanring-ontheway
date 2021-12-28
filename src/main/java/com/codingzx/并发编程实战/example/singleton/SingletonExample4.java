package com.codingzx.并发编程实战.example.singleton;

import com.codingzx.并发编程实战.annoations.UnThreadSafe;
import com.codingzx.线程同步.Singeton;

/**
 * @author codingzx
 * @description 单例
 * @date 2021/12/26 10:28
 */
@UnThreadSafe
public class SingletonExample4 {

    // 私有构造方法
    private SingletonExample4() {

    }

    private static SingletonExample4 getInstance() {
        return Singleton.INSTANCE.getIntance();
    }


    private enum Singleton {
        INSTANCE;

        private SingletonExample4 intance;

        Singleton() {
            intance = new SingletonExample4();
        }

        private SingletonExample4 getIntance() {
            return intance;
        }


    }


}
