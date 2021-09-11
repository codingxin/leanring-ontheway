package com.codingzx.设计模式.创建模式.创建模式_建造模式;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 15:55
 *
 *
 * 建造者（Builder）模式的主要角色如下。
 * 产品角色  （Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个零部件。
 * 抽象建造者（Abstract Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
 * 具体建造者 (Real Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 * 指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。
 *
 *
 *
 */
public class TestDemo {

    public static void main(String[] args) {
        AbstractBuilder abstractBuilder = new RealBuilder();
        Director director =new Director(abstractBuilder);
        Product product=director.construct();
        product.show();

    }
}
