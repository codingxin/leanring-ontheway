package com.codingzx.极客时间算法营.第一周.中等;

import java.util.Arrays;

/**
 * 某游戏中有一个包含 k 个成员的天团，天团中每个成员的能量均为 0，这个天团遇到了一堆宝物（我们用数组 A 来表示），
 * 每个宝物都有一定的能量值（即数组 A 中每个元素的值），身为帮主的需要把宝物划分成 k 个非空子数组分配给 k 个成员，
 * 每个成员的能量是对应分配到的子数组的平均值，整个天团的能量值则是每个成员的能量总和，请问如何划分可以让天团的能量值最大？
 * 注意，A 数组中必须都进行分配，且能量不一定是整数。
 * <p>
 * 示例
 * <p>
 * 输入:
 * <p>
 * A = [9,1,2,3,9]
 * K = 3
 * <p>
 * 输出: 20
 * <p>
 * 解释:
 * 一共有三个成员，最优的划分是 [9], [1, 2, 3], [9].
 * 能量值是 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * 说明:
 * 1 <= A.length <= 100.
 * 1 <= A[i] <= 10000.
 * 1 <= K <= A.length.
 * 答案误差在 10^-6 内被视为是正确的。
 */
public class extra天团能量最大值的分组 {


    public static void main(String[] args) {
        int a[] = {9, 1, 2, 3, 9};
        int a2[] = {4, 6, 1, 3, 2};
        System.out.println(largestSumOfAverages(a2, 3));
    }

    public static float largestSumOfAverages(int[] A, int K) {
        // 1. 排序找到最大的k-1个数
        // 2. 剩下的a.length-k+1 个元素求和取平均数
        if (A.length == 1) return A[0];
        Arrays.sort(A);
        float maxSum = 0;
        float avgSum = 0;
        for (int i = A.length - 1; i > A.length - 1 - (K - 1); i--) {
            maxSum += A[i];
        }
        for (int i = 0; i <= A.length - 1 - (K - 1); i++) {
            avgSum += A[i];
        }
        return maxSum + avgSum / (A.length - K + 1);  // K-1 +   A.length - K + 1 =A.length
    }
}
