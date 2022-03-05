package com.codingzx.deke.review;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author codingzx
 * @description
 * @date 2022/3/5 10:53
 */
public class 全排列 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            getAll(n);
        }

    }


    public static void getAll(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        dfs(arr, 0, n - 1);
    }


    public static void dfs(int[] arr, int x, int y) {
        if (x == y) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = x; i <= y; i++) {
            // 固定 每一个数字
            swap(arr, x, i);
            dfs(arr, x + 1, y);
            swap(arr, x, i);
        }


    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


}
