package com.codingzx.设计模式.结构模式.结构模式_桥接模式;

/**
 * @author codingzx
 * @description
 * @date 2021/9/21 13:43
 *
 * AbstraShape 抽象类shape  ，抽象方法draw
 *
 * ExtendAbstractShap 继承 AbstraShape ，构造方法传入颜色  ; draw方法 调用 drawCircle方法
 *
 * DrawAPI  颜色接口
 * GreenCircle 绿色   实现
 * RedCircle  红色
 */
public class BridgePatternDemo {


    public static void main(String[] args) {
        AbstraShape redCircle = new ExtendAbstractShap(100, 100, 10, new RedCircle());
        AbstraShape greenCircle = new ExtendAbstractShap(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }


}
