package com.codingzx.并发编程实战.example.singleton;

import com.codingzx.并发编程实战.annoations.ThreadSafe;

/**
 * @author codingzx
 * @description 双重校验锁
 * @date 2021/12/26 10:28
 */
@ThreadSafe
public class SingletonExample3 {

    // 私有构造方法
    private SingletonExample3() {

    }

    /**
     *
     * 1.memory  = allocate（） 分配对象的内存空间
     * 2.ctorInstance（） 初始化对象
     * 3.instance = memory 设置instance指向刚分配的内存
     *
     *  第二步  第三步  容易被CPU指令重排
     *  加volatile 防止指令重排
     */
    private static volatile  SingletonExample3 instance = null;
    // private static SingletonExample3 instance = null;

    // 静态工程方法
    private static SingletonExample3 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample3.class) {
                instance = new SingletonExample3();
            }
        }
        return instance;
    }


}
