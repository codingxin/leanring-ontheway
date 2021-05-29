package com.codingzx.leetcode.剑指offer.第一周;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author codingzx
 * @description * @Description 输入 10，9，2，5，3，7，101，18
 * * 输出 4
 * * 最长的子序列为 2，3，7，101 长度为4
 * * 1. 算法可能时间复杂度为O（N^2）  - 动态规划法
 * * dp代表以当前为结尾的最长子序列长度
 * *       10 9 2 5 3 7 101 18
 * * dp[i] 1  1 1 1 2 3  4   4
 * * <p>
 * * <p>
 * *        2, 5, 1, 5, 4, 5
 * * dp[i]  1  2  1  2  2  3
 * * <p>
 * * <p>  // dp 当前数字 最长子序列长度
 * // 状态转移方程 dp[k] = Math.max(dp[i],dp[j]+1)
 * @date 2021/5/29 10:19
 */
public class 最长公共子序列 {

    public static int lenthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();

    }

    public static void main(String[] args) {
        int a[] = {2, 5, 1, 5, 4, 5};
        int a2[] = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lenthOfLIS(a2));
    }


}
