package com.codingzx.设计模式.创建模式_工厂方法模式.抽象工厂;

import com.codingzx.设计模式.创建模式_工厂方法模式.普通工厂.Shape;

public class AbstractFactoryPatternDemo {


    public static void main(String[] args) {
        // 获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        // 获取图形
        Shape circleShape = shapeFactory.getShape("CIRCLE");
        circleShape.draw();

        // 获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        // 获取颜色
        Color redColor = colorFactory.getColor("RED");
        redColor.fill();


    }


}
