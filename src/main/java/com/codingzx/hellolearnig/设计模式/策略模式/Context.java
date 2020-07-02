package com.codingzx.hellolearnig.设计模式.策略模式;

/**
 * @author created by Codingzx}
 * @Classname Context
 * @Description TODO 锦囊
 * @Date 2019-09-17 19:15
 */
public class Context {
    private IStrategy iStrategy;

    public  Context(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void operate(){
        this.iStrategy.operate();
    }
}
