package com.codingzx.设计模式.创建模式.创建模式_建造模式;

import lombok.ToString;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 15:56
 */
@ToString
class Product {

    private String partA;

    private String partB;

    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        //显示产品的特性
       System.out.println(this.toString());
    }
}
