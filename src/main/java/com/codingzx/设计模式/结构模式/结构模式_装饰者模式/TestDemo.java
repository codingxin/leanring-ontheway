package com.codingzx.设计模式.结构模式.结构模式_装饰者模式;

import com.codingzx.设计模式.结构模式.结构模式_装饰者模式.basic.CircleShape;
import com.codingzx.设计模式.结构模式.结构模式_装饰者模式.basic.RectangleShape;
import com.codingzx.设计模式.结构模式.结构模式_装饰者模式.basic.Shape;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 17:17
 *
 * Shape  普通形状接口
 * CircleShape   圆形实现
 * RectangleShape 正方形实现
 *
 * AbstractShape  抽象类形状接口
 * Decorator  抽象类继承接口   实现装饰效果
 *
 *
 *
 */
public class TestDemo {

    public static void main(String[] args) {

        Shape circle = new CircleShape();
        System.out.println("Circle with normal border");
        circle.draw();

        AbstractShape redCircle = new Decorator(new CircleShape());
        AbstractShape redRectangle = new Decorator(new RectangleShape());
        //AbstraShape redCircle = new RedShapeDecorator(new Circle());
        //AbstraShape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }

}
