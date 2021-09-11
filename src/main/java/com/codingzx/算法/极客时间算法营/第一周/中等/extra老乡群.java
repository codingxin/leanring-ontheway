package com.codingzx.算法.极客时间算法营.第一周.中等;

import java.util.*;

/**
 * 某公司有 N 名员工，其中有些是来自同一个地方的，有些则不是。他们的老乡关系具有传递性。
 * <p>
 * 如果已知 A 是 B 是老乡，B 是 C 也是老乡，那么我们可以认为 A 跟 C 也是老乡。所谓的老乡群，就是指来自同一个地方的员工集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示员工之间的老乡关系。
 * 如果 Mi = 1，表示已知第 i 个和第 j 个是老乡，否则为不知道。
 * 请输出所有员工中的已知的老乡群总数。
 * <p>
 * 示例
 * <p>
 * 输入：
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * <p>
 * * [[1,1,0，1],
 * * [1,1,0,0 ],
 * * [0,0,1,0]
 * [0,0,0,1]]
 *
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * 已知员工 0 和员工 1 互为老乡，他们在一个老乡群。
 * 员工 2 自己在一个老乡群。所以返回 2 。
 */
public class extra老乡群 {
    /**
     * 查找根节点
     * 确定节点i的父节点 层层往上寻找 找到则返回i
     */
    static int find(int parent[], int i) {
        System.out.println(Arrays.toString(parent));
        if (parent[i] == -1) {
            System.out.println("返回的父节点为" + i);
            return i;
        }
        return find(parent, parent[i]);
    }

    /**
     * 联合根节点
     */
    static void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset) {
            parent[xset] = yset;
            System.out.println("x为" + x + ",y为" + y + ",xset=" + xset + "yset=" + yset
                    + ",Start" + parent[xset]);
        }
    }

    public static int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        // 1，1  2，2  3，3  单独的每个节点 -1
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                // 如果 i,j  0,1 1,0 这种情况
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}};
        System.out.println(findCircleNum(a));
    }


    public static int findNum(int[][] M) {
        int[] parent = new int[M.length]; // 存放每个节点的父节点的坐标，如果当前节点就是父节点 则为-1
        Arrays.fill(parent, -1);
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union1(parent, i, j);
                }
            }
        }
        for (int k : parent) {
            if (k == -1) count++;
        }
        return count;
    }

    static void union1(int[] parent, int i, int j) {
        int xparent = find1(parent, i);
        int yparent = find1(parent, j);
        if (xparent != yparent) {
            // 如果 01 =10 且 0和1 的父节点不一样 则指定 0的父节点为 1
            parent[xparent] = yparent;
        }
    }

    static int find1(int[] parent, int n) {
        if (parent[n] == -1) {
            return n;
        }
        return find1(parent, parent[n]);
    }


}
