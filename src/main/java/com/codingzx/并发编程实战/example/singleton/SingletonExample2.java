package com.codingzx.并发编程实战.example.singleton;

import com.codingzx.并发编程实战.annoations.ThreadSafe;

/**
 * @author codingzx
 * @description   饿汉模式  安全
 * @date 2021/12/26 10:28
 */
@ThreadSafe
public class SingletonExample2 {

    // 私有构造方法
    private SingletonExample2() {

    }

    //  单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态工程方法
    private static SingletonExample2 getInstance() {
        return instance;
    }


}
