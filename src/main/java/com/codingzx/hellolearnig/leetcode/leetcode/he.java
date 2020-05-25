package com.codingzx.hellolearnig.leetcode.leetcode;

import com.codingzx.hellolearnig.leetcode.leetcode.entity.ListNode;

import java.math.BigDecimal;

/**
 * @author created by zhangxin27695
 * @Classname he
 * @Description
 * @Date 2019-11-09 10:24
 */
public class he {

    public static void main(String[] args) {
        /**
         * 对象相等是赋值内存相等
         */
//        ListNode listNode = new ListNode(1);
//        ListNode hello = listNode;
//        System.out.println(listNode.val);
//        System.out.println(hello.val);
//        listNode.val = 2;
//        System.out.println(hello.val);

        String a = new String("hello");
        String b = new String("hello");
        System.out.println(a==b);


        String c = "hello";
        String d = new String("hello");
        System.out.println(c==d);

        String z="hello";
        String x="hello";
        String v=z;
        System.out.println(z==x);
        System.out.println(x==v);

        System.out.println("hello" == "hello");



    }
}
