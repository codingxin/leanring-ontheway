package com.codingzx.设计模式.创建模式_工厂方法模式.抽象工厂;

import com.codingzx.设计模式.创建模式_工厂方法模式.普通工厂.Shape;

public abstract class AbstractFactory {

    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);

}
