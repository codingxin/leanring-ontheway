package com.codingzx.hellolearnig.设计模式.代理模式.静态代理;

import com.codingzx.hellolearnig.设计模式.代理模式.HelloService;

/**
 * @author created by zhangxin27695
 * @Classname HelloServiceProxy
 * @Description
 * @Date 2020-07-03 10:06
 */
class HelloServiceProxy implements HelloService {
    private HelloService helloService;

    public HelloServiceProxy(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public void sayHello() {
        System.out.println("Before say hello...");
        helloService.sayHello();
        System.out.println("After say hello...");
    }
}
