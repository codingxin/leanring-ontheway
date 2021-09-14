package com.codingzx.设计模式.创建模式.创建模式_原型模式;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 16:46
 */
public class SquareShape extends Shape{

    public SquareShape(){
        type = "SquareShape";
    }

    @Override
    public void draw() {
        System.out.println("Inside SquareShape::draw() method.");
    }

}
