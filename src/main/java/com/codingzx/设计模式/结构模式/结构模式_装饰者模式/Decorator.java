package com.codingzx.设计模式.结构模式.结构模式_装饰者模式;


import com.codingzx.设计模式.结构模式.结构模式_装饰者模式.basic.Shape;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 17:10
 */
public class Decorator extends AbstractShape {

    public Decorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        shape.draw();
        setRedBorder();
    }

    private void setRedBorder(){
        System.out.println("装饰者开始装饰");
    }
}