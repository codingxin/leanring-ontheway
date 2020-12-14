package com.codingzx.设计模式.创建模式_建造者模式;

import lombok.Data;

/**
 * (1) 产品角色 ： 包含多个组成部件的复杂对象
 */
@Data
class Product {

    private String partA;

    private String partB;

    private String partC;

    public void show() {
        // 显示产品的特性
    }


}
