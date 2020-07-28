package com.codingzx.leetcode.leetcode.中级算法;

/**
 * @author created by zhangxin27695
 * @Classname _240搜索二维矩阵II
 * @Description 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * @Date 2019-11-19 14:11
 */
public class _240搜索二维矩阵II {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return false;
        }
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j <= matrix[0].length - 1) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] a={};
//        numberOfSubarrays(a, 3);
        System.out.println("这个数组" + searchMatrix(a, 1));
    }
}
