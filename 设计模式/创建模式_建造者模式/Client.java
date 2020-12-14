package com.codingzx.设计模式.创建模式_建造者模式;


/**
 * 客户类
 */
public class Client {
    public static void main(String[] args) {
        AbstractBuilder builder = new RealBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        product.show();
    }
}
