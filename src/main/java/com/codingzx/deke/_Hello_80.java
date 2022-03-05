package com.codingzx.deke;


import java.util.*;
import java.util.stream.IntStream;

/*
        给定参数n,从1到n会有n个整数:1,2,3,...,n,
        这n个数字共有n!种排列.
      按大小顺序升序列出所有排列的情况,并一一标记,
      当n=3时,所有排列如下:
      "123" "132" "213" "231" "312" "321"
      给定n和k,返回第k个排列.

      输入描述:
        输入两行，第一行为n，第二行为k，
        给定n的范围是[1,9],给定k的范围是[1,n!]。
      输出描述：
        输出排在第k位置的数字。

      实例1：
        输入:
          3
          3
        输出：
          231
        说明
          3的排列有123,132,213...,那么第三位置就是213

      实例2：
        输入
          2
          2
        输出：
          21
        说明
          2的排列有12,21，那么第二位置的为21
   */
public class _Hello_80 {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int k = Integer.parseInt(in.nextLine());
        StringBuilder sb = new StringBuilder();
        //   给定  3
        //  1  2  3 排列组合的所有数 然后 第 k大的
        // 123  132  213  231  312  321
        // 保存所有的数字
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        getResult(array, 0, n - 1);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.get(k-1));
    }

    public static void getResult(int[] array, int x, int y) {
        if (x == y) {
            StringBuilder sb = new StringBuilder();
            System.out.println(Arrays.toString(array));
            Arrays.stream(array).forEach(sb::append);
            list.add(Integer.valueOf(sb.toString()));
            return;
        }
        for (int i = x; i <= y; i++) {
            // 第 i 位数字 开始 固定
            swap(array, i, x);
            // 固定首位
            getResult(array, x + 1, y);
            swap(array, i, x);
        }

    }

    public static void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }


}
