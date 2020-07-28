package com.codingzx.设计模式.单例模式;

/**
 * @author created by zhangxin27695
 * @Classname 懒汉式单例
 * @Description
 * @Date 2020-06-16 11:29
 */
public class 懒汉式单例 {
    // 声明变量
    public static volatile 懒汉式单例 instance = null;

    // 私有化构造对象
    private 懒汉式单例() {

    }

    // 提供对外方法
    public static 懒汉式单例 getInstance() {
        if (instance == null) {
            synchronized (懒汉式单例.class) {
                if (instance == null) {
                    instance = new 懒汉式单例();
                }
            }
        }
        return instance;
    }
}
