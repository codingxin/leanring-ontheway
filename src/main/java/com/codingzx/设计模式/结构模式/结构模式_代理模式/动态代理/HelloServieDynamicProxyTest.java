package com.codingzx.设计模式.结构模式.结构模式_代理模式.动态代理;

import com.codingzx.设计模式.结构模式.结构模式_代理模式.HelloService;
import com.codingzx.设计模式.结构模式.结构模式_代理模式.HelloServiceImpl;

/**
 * @author created by zhangxin27695
 * @Classname HelloServieDynamicProxyTest
 * @Description
 * @Date 2020-07-03 10:04
 */
public class HelloServieDynamicProxyTest {
    public static void main(String[] args){
        HelloService helloService = new HelloServiceImpl();
        HelloService dynamicProxy = (HelloService) new HelloServiceDynamicProxy(helloService).getProxyInstance();
        dynamicProxy.sayHello();
    }
}
