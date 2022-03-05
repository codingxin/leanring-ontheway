package com.codingzx.并发编程实战.example;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;


import java.util.Collections;
import java.util.Map;

/**
 * @author codingzx
 * @description final 修饰 类  方法 变量
 * <p>
 * <p>
 * 修饰类 ： 不能被继承
 * 修饰方法：1. 锁定方法不被继承类修改  2. 效率     （private方法 被 隐转化为final）
 * 修饰变量： 基本数据类型（值不能改变）    引用对象类型（地址不能改变）
 * @date 2021/12/26 11:03
 */
public class TestFinal {

    private static final Integer a = 1;
    private static final String b = "hello";
    private static Map<Integer, Integer> c = Maps.newHashMap();

    private final static ImmutableList list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap map = ImmutableMap.of(1, 2, 3, 4, 5, 6);

    private final static ImmutableMap map2 = ImmutableMap.builder().put(1, 2).put(3, 4).build();

    static {
        c = Collections.unmodifiableMap(c);
    }

    public static void main(String[] args) {
        // a = 2;
        // b = "1";
        // set.add(1);
        System.out.printf( map2.get(1).toString());
    }

}
