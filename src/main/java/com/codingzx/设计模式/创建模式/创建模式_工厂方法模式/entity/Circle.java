package com.codingzx.设计模式.创建模式.创建模式_工厂方法模式.entity;

/**
 * @author created by zhangxin27695
 * @Classname CircleShape
 * @Description
 * @Date 2020-07-30 10:03
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside CircleShape::draw() method.");
    }
}
