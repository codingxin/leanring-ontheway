package com.codingzx.并发编程实战.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author codingzx
 * @description
 * @date 2021/12/14 21:23
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface Recommend {

    String value() default "";
}
