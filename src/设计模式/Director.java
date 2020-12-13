package com.codingzx.设计模式.创建模式_建造者模式;

/**
 * (4) 指挥者：调用建造者中的方法完成复杂对象的创建。
 */
class Director {
    private AbstractBuilder builder;

    public Director(AbstractBuilder builder) {
        this.builder = builder;
    }

    //产品构建与组装方法
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}