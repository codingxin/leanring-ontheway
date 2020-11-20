package com.codingzx.设计模式.创建模式_工厂方法模式.抽象工厂;

public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}