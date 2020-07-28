package com.codingzx.leetcode.动态规划;

import java.util.Arrays;

/**
 * @author created by zhangxin27695
 * @Classname 最长公共子序列
 * @Description 输入 10，9，2，5，3，7，101，18
 * 输出 4
 * 最长的子序列为 2，3，7，101 长度为4
 * 1. 算法可能时间复杂度为O（N^2）  - 动态规划法
 * dp代表以当前为结尾的最长子序列长度
 *       10 9 2 5 3 7 101 18
 * dp[i] 1  1 1 1 2 3  4   4
 * <p>
 * <p>
 *        2, 5, 1, 5, 4, 5
 * dp[i]  1  2  1  2  2  3
 * <p>
 * <p>
 * 2. 进阶为 O（nlogn）  - 二分查找法  TODO
 * @Date 2020-07-17 15:46
 */
public class 最长公共子序列 {

    public static void main(String[] args) {
        int a[] = {2, 5, 1, 5, 4, 5};
        System.out.println(lenthOfLIS(a));
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int lenthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];  // dp数组存储以每个元素为结尾的最长子串长度
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {  // 只要子序列
                    System.out.println("比较的i为" + i + "比较的j为" + j + " dp[i]" + dp[i] + ",dp[j]为" + dp[j]);
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // 每次取子序列比他小的作比较
                }
            }

        }
        for (int n : dp) {
            max = max > n ? max : n;
            System.out.println(n);
        }
        return max;
    }

    /**
     * 二分查找
     * @param nums
     * @return
     */
    public static int lenthOfLIS2(int[] nums) {
        return 1;
    }
}
