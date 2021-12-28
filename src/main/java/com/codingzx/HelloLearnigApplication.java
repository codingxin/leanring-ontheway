package com.codingzx;

import com.codingzx.并发编程实战.拦截器和过滤器.HttpFilter;
import com.codingzx.并发编程实战.拦截器和过滤器.HttpInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class HelloLearnigApplication extends WebMvcConfigurationSupport {


    public static void main(String[] args) {
        SpringApplication.run(HelloLearnigApplication.class, args);
    }


    @Bean
    public FilterRegistrationBean<HttpFilter> httpFilterTest() {
        FilterRegistrationBean<HttpFilter> filterRegistrationBean = new FilterRegistrationBean<HttpFilter>();
        // 拦截路径
        filterRegistrationBean.addUrlPatterns("/threadLocal/**");
        filterRegistrationBean.setName("HttpFilterTest");
        filterRegistrationBean.setFilter(new HttpFilter());
        return filterRegistrationBean;
    }




    // 防止 过滤器 获取不到Service实例
    @Bean
    public HttpInterceptor getMyInterceptor(){
        System.out.println("注入了MyInterceptor");
        return new HttpInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**");
    }




}
