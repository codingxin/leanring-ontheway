package com.codingzx.设计模式.创建模式.创建模式_工厂方法模式.entity;

/**
 * @author created by zhangxin27695
 * @Classname Square
 * @Description
 * @Date 2020-07-30 10:03
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
