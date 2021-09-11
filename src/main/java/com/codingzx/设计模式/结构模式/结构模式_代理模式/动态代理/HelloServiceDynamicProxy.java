package com.codingzx.设计模式.结构模式.结构模式_代理模式.动态代理;

import com.codingzx.设计模式.结构模式.结构模式_代理模式.HelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author created by zhangxin27695
 * @Classname HelloServiceDynamicProxy
 * @Description 一般都使用的是动态代理模式，在这需要说明一下动态代理的基本思路：首先实现InvocationHandler接口，
 * 然后通过java API创建代理类，最后动态加载代理类,代理类实现接口,使用handler（Proxy.newProxyInstance）以及调用invoke方法
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
                System.out.println("Before say Start...");
                Object ret = method.invoke(helloService, args);
                System.out.println("After say Start...");
                return ret;
            }
        });
    }


}
