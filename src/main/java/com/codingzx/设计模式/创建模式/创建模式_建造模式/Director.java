package com.codingzx.设计模式.创建模式.创建模式_建造模式;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 16:00
 */
public class Director {

    private AbstractBuilder abstractBuilder;

    public Director(AbstractBuilder builder) {
        this.abstractBuilder = builder;
    }

    //产品构建与组装方法
    public Product construct() {
        abstractBuilder.buildPartA();
        abstractBuilder.buildPartB();
        abstractBuilder.buildPartC();
        return abstractBuilder.getResult();
    }


}
