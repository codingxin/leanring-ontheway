package com.codingzx.设计模式.创建模式.创建模式_建造模式;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 15:57
 */
public abstract class AbstractBuilder {

    //创建产品对象
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    //返回产品对象
    public Product getResult() {
        return product;
    }

}
