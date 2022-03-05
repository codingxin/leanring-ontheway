package com.codingzx.deke.review;

/**
 * @author codingzx
 * @description
 * @date 2022/3/5 11:00
 */
public class 查找岛屿 {


    public static void main(String[] args) {
        char[][] nums = {{
                '1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'}, {
                '0', '0', '1', '0', '1'}};
        System.out.println(numIslands(nums));
    }

    private static int numIslands(char[][] nums) {
        int x = nums.length;
        int y = nums[0].length;
        int count = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (nums[i][j] == '1') {
                    count++;
                    dfs(nums, i, j);
                    continue;
                }

            }
        }
        return count;

    }


    private static void dfs(char[][] nums, int x, int y) {
        int n = nums.length;
        int m = nums[0].length;
        if (x < 0 || y < 0 || x >= n || y >= m || nums[x][y] == '0') return;
        nums[x][y] = '0';
        // 上下左右四个方向查找
        dfs(nums, x, y - 1);
        dfs(nums, x, y + 1);
        dfs(nums, x - 1, y);
        dfs(nums, x + 1, y);

    }


}
