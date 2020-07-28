package com.codingzx.设计模式.代理模式.动态代理;

import com.codingzx.设计模式.代理模式.HelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author created by zhangxin27695
 * @Classname HelloServiceDynamicProxy
 * @Description
 * @Date 2020-07-03 10:01
 */
public class HelloServiceDynamicProxy {

    private HelloService helloService;

    public HelloServiceDynamicProxy(HelloService helloService) {
        this.helloService = helloService;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(helloService.getClass().getClassLoader(), helloService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Before say hello...");
                Object ret = method.invoke(helloService, args);
                System.out.println("After say hello...");
                return ret;
            }
        });


    }


}
