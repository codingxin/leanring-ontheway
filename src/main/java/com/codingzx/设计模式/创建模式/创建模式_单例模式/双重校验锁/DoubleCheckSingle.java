package com.codingzx.设计模式.创建模式.创建模式_单例模式.双重校验锁;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 15:34
 */
public class DoubleCheckSingle {
    private volatile static DoubleCheckSingle singleton;

    private DoubleCheckSingle() {
    }

    public static DoubleCheckSingle getSingleton() {
        if (singleton == null) {
            synchronized (DoubleCheckSingle.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckSingle();
                }
            }
        }
        return singleton;
    }


}
