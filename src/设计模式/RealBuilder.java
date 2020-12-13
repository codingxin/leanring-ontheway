package com.codingzx.设计模式.创建模式_建造者模式;


/**
 * (3)具体建造者：实现了抽象的建造者接口
 */
public class RealBuilder extends AbstractBuilder {

    @Override
    public void buildPartA() {
        product.setPartA("建造 PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("建造 PartB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("建造 PartC");
    }

}
