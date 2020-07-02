package com.codingzx.hellolearnig.设计模式.单例模式;

/**
 * @author created by zhangxin27695
 * @Classname 饿汉式单例
 * @Description
 * @Date 2020-06-16 11:29
 */
public class 饿汉式单例 {

    // 直接创建对象
    public static 饿汉式单例 instance = new 饿汉式单例();

    // 私有化构造对象
    private 饿汉式单例() {

    }

    // 返回对象实例
    public static 饿汉式单例 getInstance() {
        return instance;
    }

}
