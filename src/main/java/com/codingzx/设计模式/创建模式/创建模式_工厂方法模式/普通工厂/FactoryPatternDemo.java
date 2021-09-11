package com.codingzx.设计模式.创建模式.创建模式_工厂方法模式.普通工厂;

import com.codingzx.设计模式.创建模式.创建模式_工厂方法模式.entity.Shape;

/**
 * @author created by zhangxin27695
 * @Classname FactoryPatternDemo
 * @Description
 * @Date 2020-07-30 10:04
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //调用 Square 的 draw 方法
        shape3.draw();
    }
}
