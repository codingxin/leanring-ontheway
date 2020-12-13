package com.codingzx.设计模式.创建模式_建造者模式;

/**
 * (2)抽象建造者：包含创建产品各个子部件的抽象方法
 */
public abstract class AbstractBuilder {
    // 创建产品对象
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Product getResult() {
        return product;
    }


}
