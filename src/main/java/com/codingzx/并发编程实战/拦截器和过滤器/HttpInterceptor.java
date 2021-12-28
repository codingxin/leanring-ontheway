package com.codingzx.并发编程实战.拦截器和过滤器;

import com.codingzx.并发编程实战.example.threadLocal.RequestHolder;
import com.codingzx.并发编程实战.service.TestService;
import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author codingzx
 * @description 拦截器
 * @date 2021/12/26 14:30
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    /**
     * 注入为空：
     * 因为加载顺序导致的问题，拦截器加载的时间点在springcontext之前，而Bean又是由spring进行管理。
     * 解决方案也很简单，我们在注册拦截器之前，先将Interceptor 手动进行注入。注意：在registry.addInterceptor()注册的是拦截器 实例。
     */
    @Autowired
    private TestService testService;

    // 接口处理之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截器 preHandle");
        testService.sayHello();
        return true;
        // return super.preHandle(request, response, handler);
    }

    // 接口处理之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("拦截器 afterCompletion");
        RequestHolder.remove();
        return;
        //super.afterCompletion(request, response, handler, ex);
    }
}
