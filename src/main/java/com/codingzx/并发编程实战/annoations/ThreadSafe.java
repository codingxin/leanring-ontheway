package com.codingzx.并发编程实战.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author codingzx
 * @description
 * 用来标记线程安全的类
 * @date 2021/12/14 21:21
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadSafe {

    String value() default "";







}
