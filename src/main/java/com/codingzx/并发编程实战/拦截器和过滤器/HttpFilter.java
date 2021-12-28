package com.codingzx.并发编程实战.拦截器和过滤器;


import com.codingzx.并发编程实战.example.threadLocal.RequestHolder;
import com.codingzx.并发编程实战.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author codingzx
 * @description 过滤器
 * @date 2021/12/26 14:22
 * @difference 两者的本质区别：拦截器（Interceptor）是基于Java的反射机制，而过滤器（Filter）是基于函数回调。
 * 从灵活性上说拦截器功能更强大些，Filter能做的事情，都能做，而且可以在请求前，请求后执行，比较灵活。
 * Filter主要是针对URL地址做一个编码的事情、过滤掉没用的参数、安全校验（比较泛的，比如登录不登录之类），
 * 太细的话，还是建议用interceptor。不过还是根据不同情况选择合适的。
 */
@Slf4j
@Component
public class HttpFilter implements Filter {

    @Autowired
    private TestService testService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器init ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("过滤器doFilter ");
        testService.sayHello();;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("do filter:{} , {}", Thread.currentThread().getId(), request.getRequestURI());
        RequestHolder.add(Thread.currentThread().getId());
        // 继续执行
        filterChain.doFilter(servletRequest, servletResponse);

        // 登陆后从session中获取值
        // request.getSession().getAttribute("");
    }

    @Override
    public void destroy() {

        log.info("过滤器destroy ");
    }
}
