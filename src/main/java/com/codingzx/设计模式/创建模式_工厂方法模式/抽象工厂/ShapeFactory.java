package com.codingzx.设计模式.创建模式_工厂方法模式.抽象工厂;

import com.codingzx.设计模式.创建模式_工厂方法模式.普通工厂.Circle;
import com.codingzx.设计模式.创建模式_工厂方法模式.普通工厂.Rectangle;
import com.codingzx.设计模式.创建模式_工厂方法模式.普通工厂.Shape;
import com.codingzx.设计模式.创建模式_工厂方法模式.普通工厂.Square;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
