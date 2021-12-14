package com.codingzx.设计模式.结构模式.结构模式_桥接模式;

/**
 * @author codingzx
 * @description
 * @date 2021/9/21 13:39
 */
public class ExtendAbstractShap extends AbstraShape {


    private int x, y, radius;

    public ExtendAbstractShap(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        System.out.println("桥接方法开始");
        drawAPI.drawCircle(radius, x, y);
    }

}
