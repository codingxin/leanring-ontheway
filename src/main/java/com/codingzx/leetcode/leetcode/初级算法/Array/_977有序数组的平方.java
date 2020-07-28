package com.codingzx.leetcode.leetcode.初级算法.Array;


import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * @author created by zhangxin27695
 * @Classname _977有序数组的平方
 * @Description 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 来源：力扣（LeetCode）
 * @Date 2019-11-20 15:37
 */
public class _977有序数组的平方 {
    public static int[] sortedSquares(int[] A) {
      for(int i=0;i<A.length;i++){
          A[i]*=A[i];
      }

        Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {
        int a[] = {7, 1, 5, 3, 6, 4};

        sortedSquares(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}
