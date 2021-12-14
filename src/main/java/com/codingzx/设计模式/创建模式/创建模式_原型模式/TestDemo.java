package com.codingzx.设计模式.创建模式.创建模式_原型模式;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 16:48
 */
public class TestDemo {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("AbstraShape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("AbstraShape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("AbstraShape : " + clonedShape3.getType());

    }


}
