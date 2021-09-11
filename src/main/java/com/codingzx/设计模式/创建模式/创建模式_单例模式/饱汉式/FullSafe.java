package com.codingzx.设计模式.创建模式.创建模式_单例模式.饱汉式;

/**
 * @author created by zhangxin27695
 * @Classname 懒汉式单例  线程不安全
 * @Description
 * @Date 2020-06-16 11:29
 */
public class FullSafe {
    // 声明变量
    public static volatile FullSafe instance = null;

    // 私有化构造对象
    private FullSafe() {

    }

    // 提供对外方法
    public static synchronized FullSafe getInstance() {
        if (instance == null) {
            instance = new FullSafe();
        }
        return instance;
    }
}
