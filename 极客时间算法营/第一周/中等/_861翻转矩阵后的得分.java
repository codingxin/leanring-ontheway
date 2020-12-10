package com.codingzx.极客时间算法营.第一周.中等;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 有一个二维矩阵A 其中每个元素的值为0或者1
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * <p>
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * <p>
 * 返回尽可能高的分数。
 * <p>
 * 示例：
 * <p>
 * 输入：[[0,0,1,1],
 * [1,0,1,0],
 * [1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],
 * [1,0,0,1],
 * [1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * 提示：
 * <p>
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j]是0或者 1
 */
public class _861翻转矩阵后的得分 {

    public static void main(String[] args) {
        int[][] a = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        reverseArray(a);
        for (int i : a[0]) {
            System.out.println(" " + i);
        }
        for (int i : a[1]) {
            System.out.println(" " + i);
        }
        for (int i : a[2]) {
            System.out.println(" " + i);
        }
    }

    public static void reverseArray(int[][] arr) {
        // 先保证第一列全为 1
        // 依次翻转剩下的列 判断 0的个数是否大于1/2 再翻转
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 0) {
                // 翻转该列所在行
                reverse(arr, i, -1);
            }
        }
        // 翻转剩余的列
        int count = 0; // 计算每一列的0个数
        for (int i = 1; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] == 0) count++;
                if (j == arr.length - 1 && count > arr.length / 2) {
                    reverse(arr, -1, i);
                }
            }
        }
    }

    public static void reverse(int[][] arr, int n, int m) {
        if (m != -1) {
            //  翻转列  第m列   循环行坐标
            for (int i = 0; i < arr.length; i++) {
                arr[i][m] ^= 1;
            }
        } else {
            // 翻转行 第n行
            for (int i = 0; i < arr[0].length; i++) {
                arr[n][i] ^= 1;
            }
        }
    }


}
