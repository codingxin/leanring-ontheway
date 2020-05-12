package com.codingzx.hellolearnig.leetcode.leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author created by zhangxin27695
 * @Classname _36有效的数独
 * @Description 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * @Date 2019-11-18 10:13
 */
public class _36有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][9];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][9];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }

    //-----------------------!-----------------------------------------

    public boolean isValidSudoku2(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }
//-----------------------!-----------------------------------------

    public boolean isValidSudoku3(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && !check3(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean check3(char[][] board, int x, int y) {
        char num = board[x][y];

        // 判断同一行是否合法
        for (int i = 0; i != y && i < board.length; i++) {
            if (board[x][i] == num) {
                return false;
            }
        }

        // 判断同一列是否合法
        for (int i = 0; i != x && i < board.length; i++) {
            if (board[i][y] == num) {
                return false;
            }
        }

        // 判断九宫格内是否合法
        int beginX = 3 * (x / 3);
        int beginY = 3 * (y / 3);
        for (int i = beginX; i < beginX + 3; i++) {
            for (int j = beginY; j < beginY + 3; j++) {
                if (i != x && j != y && board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;

    }

//-----------------------!-----------------------------------------
    //位运算

    public boolean isValidSudoku4(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] sub = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //当前字符是'.'则跳过, 直接进入下一轮循环
                if (board[i][j] == '.')
                    continue;
                //处理行
                if (!valid4(row, i, board[i][j] - 48))
                    return false;
                //处理列
                if (!valid4(col, j, board[i][j] - 48))
                    return false;
                //处理子数独
                int index = i / 3 * 3 + j / 3;
                if (!valid4(sub, index, board[i][j] - 48))
                    return false;
            }
        }
        return true;
    }

    public boolean valid4(int[] arr, int i, int cur) {
        //cur出现过, 返回false
        if (((arr[i] >> cur) & 1) == 1)
            return false;
        //cur没出现过, 标记为出现过
        arr[i] = arr[i] | (1 << cur);
        return true;
    }


}
