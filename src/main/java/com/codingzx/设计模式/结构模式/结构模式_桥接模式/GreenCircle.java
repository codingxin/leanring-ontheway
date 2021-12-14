package com.codingzx.设计模式.结构模式.结构模式_桥接模式;

/**
 * @author codingzx
 * @description
 * @date 2021/9/21 13:36
 */
public class GreenCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius + ", x: " + x + ", " + y + "]");
    }

}