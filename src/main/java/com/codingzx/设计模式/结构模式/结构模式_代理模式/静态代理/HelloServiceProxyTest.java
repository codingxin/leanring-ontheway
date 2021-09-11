package com.codingzx.设计模式.结构模式.结构模式_代理模式.静态代理;

import com.codingzx.设计模式.结构模式.结构模式_代理模式.HelloService;
import com.codingzx.设计模式.结构模式.结构模式_代理模式.HelloServiceImpl;

/**
 * @author created by zhangxin27695
 * @Classname HelloServiceProxyTest
 * @Description
 * @Date 2020-07-03 10:06
 */
public class HelloServiceProxyTest {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloServiceProxy proxy = new HelloServiceProxy(helloService);
        proxy.sayHello();
    }
}
