package com.codingzx.设计模式.创建模式.创建模式_建造模式;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 15:58
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
