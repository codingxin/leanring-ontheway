package com.codingzx.设计模式.创建模式_单例模式.饱汉式;

/**
 * @author created by zhangxin27695
 * @Classname 懒汉式单例
 * @Description
 * @Date 2020-06-16 11:29
 */
public class Full {
    // 声明变量
    public static volatile Full instance = null;

    // 私有化构造对象
    private Full() {

    }

    // 提供对外方法
    public static Full getInstance() {
        if (instance == null) {
            synchronized (Full.class) {
                if (instance == null) {
                    instance = new Full();
                }
            }
        }
        return instance;
    }
}
