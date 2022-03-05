package com.codingzx.leetcode.leetcode.中级算法;

/**
 * @author codingzx
 * @description
 * @date 2022/3/4 20:40
 */
public class _200岛屿数量 {

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        // 深度优先算法
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || grid[x][y] == '0' || x >= grid.length || y >= grid[0].length) return;
        grid[x][y] = '0';
        // 左
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        // 上
        // 右
        dfs(grid, x, y + 1);
        // 下
    }


    public static void main(String[] args) {
        char[][] nums = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {
                '0', '0', '0', '0', '0'}};
        System.out.println( numIslands(nums));
    }

}
