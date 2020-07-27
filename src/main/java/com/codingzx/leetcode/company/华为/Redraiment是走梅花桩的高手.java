package com.codingzx.hellolearnig.leetcode.company.华为;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname Redraiment是走梅花桩的高手
 * @Description 题目描述
 * <p>
 * Redraiment是走梅花桩的高手。Redraiment总是起点不限，从前到后，往高的桩子走，但走的步数最多，
 * 不知道为什么？你能替Redraiment研究他最多走的步数吗？
 * <p>
 * <p>
 * <p>
 * 样例输入
 * <p>
 * 6
 * <p>
 * 2 5 1 5 4 5
 * <p>
 * <p>
 * <p>
 * 样例输出
 * <p>
 * 3
 * <p>
 * <p>
 * <p>
 * 提示
 * <p>
 * Example:      1 2 3 4 5 6
 * 6个点的高度各为 2 5 1 5 4 5
 * 如从第1格开始走,最多为3步, 2 4 5
 * 从第2格开始走,最多只有1步,5
 * 而从第3格开始走最多有3步,1 4 5
 * 从第5格开始走最多有2步,4 5
 * <p>
 * 所以这个结果是3。
 * @Date 2020-07-17 11:25
 */
public class Redraiment是走梅花桩的高手 {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int n = input.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = input.nextInt();
            System.out.println(getMaxSteps(a, n));
        }

    }


    // 转化成求最长递增子序列   * 6个点的高度各为 2 5 1 5 4 5
    // * 如从第1格开始走,最多为3步, 可以到达的楼层为2 4 5
    // * 从第2格开始走,最多只有1步,5
    // * 而从第3格开始走最多有3步,1 4 5
    // * 从第5格开始走最多有2步,4 5
    // dp[1 1 1 1 1]
    public static int getMaxSteps(int[] arr, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;        // 状态方程 dp数组每个初始为1  存储的步数
            for (int j = 0; j < i; j++) {  // 判断
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); //状态转移方程
                }
            }
        }
        for (int i : dp) {
            System.out.print(i + " ");
        }
        // 找到dp数组中的最大值即可
        int max = 0;
        for (int i = 0; i < dp.length; i++)
            if (dp[i] > max) {
                max = dp[i];
            }
//        for (int i : dp) {
//            max = dp[i] > 0 ? dp[i] : 0;
//        }
//        Arrays.stream(dp).forEach(e -> {
//        });
        return max;
    }

}
