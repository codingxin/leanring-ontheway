package com.codingzx.leetcode.leetcode;

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
//        ListNode Start = listNode;
//        System.out.println(listNode.val);
//        System.out.println(Start.val);
//        listNode.val = 2;
//        System.out.println(Start.val);

        String a = new String("Start");
        String b = new String("Start");
        System.out.println(a==b);


        String c = "Start";
        String d = new String("Start");
        System.out.println(c==d);

        String z="Start";
        String x="Start";
        String v=z;
        System.out.println(z==x);
        System.out.println(x==v);

        System.out.println("Start" == "Start");



    }
}
