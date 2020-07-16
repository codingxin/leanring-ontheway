package com.codingzx.hellolearnig.leetcode.剑指offer;

import java.util.Arrays;

/**
 * @author created by zhangxin27695
 * @Classname _6旋转数组的最小数字
 * @Description 1 1 2 3 5 8
 * 0 1 1 2 3 5 8
 * @Date 2020-07-07 19:35
 */
public class _7斐波那契数列 {
    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1||n==2) {
            return 1;
        }
        return Fibonacci(n - 2) + Fibonacci(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(5));

    }
}
