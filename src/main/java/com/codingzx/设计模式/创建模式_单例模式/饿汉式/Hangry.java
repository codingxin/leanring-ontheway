package com.codingzx.设计模式.创建模式_单例模式.饿汉式;

/**
 * @author created by zhangxin27695
 * @Classname 饿汉式单例
 * @Description
 * @Date 2020-06-16 11:29
 */
public class Hangry {

    // 直接创建对象
    public static Hangry instance = new Hangry();

    // 私有化构造对象
    private Hangry() {

    }

    // 返回对象实例
    public static Hangry getInstance() {
        return instance;
    }

}
