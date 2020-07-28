package com.codingzx.设计模式.代理模式;

/**
 * @author created by zhangxin27695
 * @Classname HelloServiceImpl
 * @Description
 * @Date 2020-07-03 9:59
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("委托类say hello");
    }
}
