package com.codingzx.leetcode.company.字节跳动.兑换货币;

import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname test1
 * @Description 一行，包含一个数，表示最少收到的硬币数。
 * 示例1
 * 输入
 * 200
 * 输出
 * 17
 * 说明
 * 花200，需要找零824块，找12个64元硬币，3个16元硬币，2个4元硬币即可
 * 1. 贪心
 * 2. 动态规划
 * @Date 2020-07-27 16:08
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = 0;
            int current = 1024 - sc.nextInt();
            int a=current/64;
            int b=current%64/16;
            int c=current%64%16/4;
            int d=current%64%16%4;
        }
        sc.close();
    }

}
