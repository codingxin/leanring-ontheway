package com.codingzx.leetcode.company.华为;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author codingzx
 * @description a[0] =  1
 * a[1] =  11
 * a[2] =  21
 * a[3] =  1211
 * a[4] =  111221
 * a[5] =  312211
 * @date 2021/4/10 21:03
 */
public class hello_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            if (n == 0) System.out.println(1);
            int[] a = new int[n + 1];
            a[0] = 1;
            for (int i = 1; i <= n; i++) {
                String prenumber = String.valueOf(a[i - 1]);
                a[i] = Integer.valueOf(chulicurnumber(prenumber));
            }
            System.out.println(a[n]);
        }
    }

    /**
     * 根据前一个数字构建
     *
     * @param prenumber
     * @return
     */
    public static String chulicurnumber(String prenumber) { // 2  1   ->> 1 2 1 1 ->>  1 1  1 2 2 1
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        map.put(prenumber.charAt(0), 1);
        int k = 1; // 記錄每個數字次數
        for (int j = 1; j < prenumber.length(); ) {
            if (map.containsKey(prenumber.charAt(j))) {
                k++;
            } else {
                sb.append(prenumber.charAt(j - 1)).append(k);
                map = new HashMap<>();
                k = 1;
                map.put(prenumber.charAt(j), k);
            }
        }
        return sb.toString();
    }


}
