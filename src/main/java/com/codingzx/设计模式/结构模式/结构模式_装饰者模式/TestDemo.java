package com.codingzx.设计模式.结构模式.结构模式_装饰者模式;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 17:17
 */
public class TestDemo {

    public static void main(String[] args) {

        Shape circle = new CircleShape();
        AbstractShape redCircle = new RedShape(new CircleShape());
        AbstractShape redRectangle = new RedShape(new RectangleShape());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }

}
