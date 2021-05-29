package com.codingzx.leetcode.剑指offer.第一周;

/**
 * @author codingzx
 * @description
 * @date 2021/5/29 9:37
 */
public class _04offer二维数组查找 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;
        while (col < matrix[0].length && row >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;

    }


    public static void main(String[] args) {
        int[][] num = {{1, 2}, {5, 6}};
        System.out.println(findNumberIn2DArray(num, 2));
        System.out.println("We are happy.".replaceAll(" ", "%20"));

    }

}
