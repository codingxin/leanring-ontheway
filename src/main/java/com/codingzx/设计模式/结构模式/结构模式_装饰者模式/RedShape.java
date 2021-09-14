package com.codingzx.设计模式.结构模式.结构模式_装饰者模式;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 17:10
 */
public class RedShape extends AbstractShape {

    public RedShape(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        shape.draw();
        setRedBorder(shape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}