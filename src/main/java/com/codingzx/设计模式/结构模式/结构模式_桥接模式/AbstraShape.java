package com.codingzx.设计模式.结构模式.结构模式_桥接模式;

/**
 * @author codingzx
 * @description
 * @date 2021/9/21 13:37
 */
public abstract class AbstraShape {

    protected DrawAPI drawAPI;

    protected AbstraShape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();

}
