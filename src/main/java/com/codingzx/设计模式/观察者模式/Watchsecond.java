package com.codingzx.设计模式.观察者模式;

/**
 * @author created by zhangxin27695
 * @Classname Watchfirst
 * @Description
 * @Date 2020-07-28 19:31
 */
public class Watchsecond implements Person {

    private String name = "小李";

    public Watchsecond() {
    }

    @Override
    public void getMessage(String s) {
        System.out.println(name + "接到了电话，内容是" + s);
    }
}
