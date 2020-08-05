package com.codingzx.设计模式.工厂方法模式;

/**
 * @author created by zhangxin27695
 * @Classname Circle
 * @Description
 * @Date 2020-07-30 10:03
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
