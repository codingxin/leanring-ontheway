package com.codingzx.leetcode.company.字节跳动.兑换货币;

import java.util.Arrays;
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
 * dp[i] 状态方程定义为找第i元钱，需要的最少张数 从0-num总共num+1 种
 * 状态转移方程
 * <p>
 * //dp[i]：找i元钱最少需要多少硬币
 * //base: dp[0]=0;dp[1]=1
 * //状态转移方程：dp[i]=min(dp[i],dp[i-amount]+1);
 * <p>
 * //类比
 * //背包问题：装最少的东西将容量为1024-N的背包装满，每次可以装1/4/16/64
 * //爬楼梯问题：爬最少的次数爬完1024-N层楼梯，每次可以爬1/4/16/64层
 * @Date 2020-07-27 16:08
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 需要凑齐多少钱
            int num = 1024 - sc.nextInt();
            // 凑齐第 块钱
            int[] dp = new int[num + 1];
            int[] money = {1, 4, 16, 64};
            Arrays.fill(dp, num + 1);
            dp[0] = 0;
            for (int i = 1; i <= num; i++) {
                for (int coins : money) {
                    if(i>=coins)  dp[i] = Math.min(dp[i], dp[i - coins] + 1);
                }
                System.out.println("第"+i+"块钱需要的dp["+i+"]为"+dp[i]);
            }
            System.out.println(dp[num]);

        }
        sc.close();
    }

}
