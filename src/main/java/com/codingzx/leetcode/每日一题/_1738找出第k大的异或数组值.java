package com.codingzx.leetcode.每日一题;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author codingzx
 * @description 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足
 * 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * 0< = i <= 1< 2    0 <= j <=0  < 2
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 * 示例 1：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 1
 * 输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 * 示例 2：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 2
 * 输出：5
 * 解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
 * 示例 3：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 3
 * 输出：4
 * 解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
 * 示例 4：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 4
 * 输出：0
 * 解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。
 *  
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 0 <= matrix[i][j] <= 106
 * 1 <= k <= m * n
 */
public class _1738找出第k大的异或数组值 {
    // pre(i,j)=pre(i−1,j)⊕pre(i,j−1)⊕pre(i−1,j−1)   ⊕matrix(i,j)
    public static int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        List<Integer> result = new ArrayList<>();
        // 构造前缀和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
//                System.out.println("i:" + i + ",j" + j);
//                System.out.println(" pre[i - 1][j - 1]:" + pre[i - 1][j - 1] + ",pre[i - 1][j]:" + pre[i - 1][j] + "," +
//                        " pre[i][j - 1]" + pre[i][j - 1] + ",matrix[i - 1][j - 1]:" + matrix[i - 1][j - 1]);
                pre[i][j] = pre[i - 1][j - 1] ^ pre[i - 1][j] ^ pre[i][j - 1] ^ matrix[i - 1][j - 1];  // 因为 pre数组 已经扩充了 i / j
//                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                result.add(pre[i][j]);
//                System.out.println("pre[i][j]:" + pre[i][j]);
//                System.out.println("==============================");
            }
        }
        Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
//        result.stream().sorted();
//        System.out.println(result);
        return result.get(k - 1);
    }


    public static void main(String[] args) {
        int[][] matrix = {{5, 2}, {1, 6}};
        int m = kthLargestValue(matrix, 1);
        System.out.println(m);
    }


}
