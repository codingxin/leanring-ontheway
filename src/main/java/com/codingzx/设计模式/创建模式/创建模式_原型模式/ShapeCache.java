package com.codingzx.设计模式.创建模式.创建模式_原型模式;

import com.codingzx.设计模式.创建模式.创建模式_工厂方法模式.entity.Square;

import java.util.Hashtable;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 16:47
 */
public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap
            = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    // 对每种形状都运行数据库查询，并创建该形状
    // shapeMap.put(shapeKey, shape);
    // 例如，我们要添加三种形状
    public static void loadCache() {
        CircleShape circle = new CircleShape();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        SquareShape square = new SquareShape();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        RectangleShape rectangle = new RectangleShape();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }



}
