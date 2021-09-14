package com.codingzx.设计模式.结构模式.结构模式_装饰者模式;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 17:10
 *
 *  AbstractShape  装饰 shape  类
 *
 */
public abstract class AbstractShape implements Shape {

    protected Shape shape;

    public AbstractShape(Shape shape){
        this.shape = shape;
    }

    public void draw(){
        shape.draw();
    }
}