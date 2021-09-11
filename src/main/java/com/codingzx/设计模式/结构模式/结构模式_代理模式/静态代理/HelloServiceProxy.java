package com.codingzx.设计模式.结构模式.结构模式_代理模式.静态代理;

import com.codingzx.设计模式.结构模式.结构模式_代理模式.HelloService;

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
        System.out.println("静态代理方法开始");
        helloService.sayHello();
        System.out.println("静态代理方法结束");
    }
}
