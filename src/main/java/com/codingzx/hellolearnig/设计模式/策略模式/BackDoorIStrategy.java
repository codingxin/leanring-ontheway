package com.codingzx.hellolearnig.设计模式.策略模式;



/**
 * @author created by Codingzx}
 * @Classname BackDoorIStrategy
 * @Description
 * @Date 2019-09-17 19:12
 */
public class BackDoorIStrategy implements IStrategy {

    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力");
    }
}
