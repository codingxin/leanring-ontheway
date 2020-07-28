package com.codingzx.leetcode.剑指offer;

/**
 * @author created by zhangxin27695
 * @Classname _1二维数组的查找
 * @Description
 * @Date 2020-05-29 10:35
 */
public class _1二维数组的查找 {
    public static boolean Find(int target, int[][] array) {
        boolean flas = false;
        int row = array.length - 1;
        int col = 0;
        while (row >= 0 && col < array[0].length) {
            if (target == array[row][col]) {
                return true;
            } else if (target < array[row][col]) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }

}
