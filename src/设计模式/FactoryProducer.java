package com.codingzx.设计模式.创建模式_工厂方法模式.抽象工厂;

public class FactoryProducer {


    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }


}
