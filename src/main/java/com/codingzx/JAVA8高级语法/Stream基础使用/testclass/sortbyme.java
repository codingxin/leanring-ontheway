package com.codingzx.JAVA8高级语法.Stream基础使用.testclass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author created by zhangxin27695
 * @Classname sortbyme
 * @Description
 * @Date 2020-04-09 14:33
 */
public class sortbyme {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList(
                "Milan",
                "london",
                "San Francisco",
                "Tokyo",
                "New Delhi"
        );
        System.out.println(cities);
        //[Milan, london, San Francisco, Tokyo, New Delhi]

        /**
         * 排序方法：
         * 取出每个元素 首元素的ascii码比较，如果相等 则比较下一个
         */
        cities.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(cities);
        //[london, Milan, New Delhi, San Francisco, Tokyo]

        cities.sort(Comparator.naturalOrder());
        System.out.println(cities);
        //[Milan, New Delhi, San Francisco, Tokyo, london]
    }
}
