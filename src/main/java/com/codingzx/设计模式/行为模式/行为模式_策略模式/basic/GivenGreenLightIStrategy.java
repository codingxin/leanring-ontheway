package com.codingzx.设计模式.行为模式.行为模式_策略模式.basic;


/**
 * @author created by Codingzx}
 * @Classname BackDoorIStrategy
 * @Description TODO
 * @Date 2019-09-17 19:12
 */
public class GivenGreenLightIStrategy implements IStrategy {

    @Override
    public void operate() {
        System.out.println("这是一种GivenGreenLightIStrategy策略");
    }
}
