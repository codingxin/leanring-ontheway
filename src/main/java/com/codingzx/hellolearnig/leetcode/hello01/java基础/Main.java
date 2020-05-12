package com.codingzx.hellolearnig.leetcode.hello01.java基础;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 小明拿到了一个数列a1 , a2 , ... an ，小明想知道存在多少个区间[l,r]同时满足下列两个条件：
 * <p>
 * 条件1：1、r-l+1=k;
 * <p>
 * 条件2：2、在a l , a l+1,...ar中，存在一个数至少出现了 t 次。
 * <p>
 * 输出满足条件的区间个数。
 * 输入第一行三个整数n,k,t(1≤n,k,t≤105)。
 * <p>
 * 第二行 n 个整数，a1 , a2 , ... an (1≤ai≤105)。
 * 区间[1,3]中1出现了2次，区间[2,4]中1出现了3次，区间[3,5]中1出现了2次。所以一共有3个区间满足条件。
 * 输入：n=5 k=3 t=2
 * 5个数：3    1   1  1  2
 * 对应整数：a1 , a2 , ...  an
 * 输出：3
 */
//美团笔试第二题  2018.9.6
//参照别人代码，写出来的博客。非原创
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//输入数的个数
        int k = scanner.nextInt();// 区间长度为k
        int t = scanner.nextInt();//至少出现t次
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            //用数组保存输入序列
            a[i] = scanner.nextInt();
        }
        //表示满足条件的区间数
        int max = 0;
        //从0到5-3+1 共三次循环
        //区间后面不能超数组。所以是n-k+1个区间，因为区间长度是k
        //而且（n-k+1）+（k-1）=n
        //[] [] [] [] []  三个为一团，有三种（1，2，3）（2，3，4）（3，4，5）
        //即n-k+1个集合
        for (int i = 0; i < n - k + 1; i++) {
            //函数返回区间【i,i+k-1】是否满足两个条件，满足就加一
            //数组从0开始，但是数列从1开始 i+k-1
            max += getcount(a, i, i + k - 1, t);
        }
        System.out.println(max);
    }

    //判断每个区间是否存在存在返回 1

    public static int getcount(int[] a, int min, int max, int t) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = min; i <= max; i++) {
            if (map.get(a[i]) == null) {
                //第一次循环初始化，key：a1-an，Value：出现次数
                map.put(a[i], 1);
            } else {
                map.put(a[i], map.get(a[i]) + 1);
                //输出现在的map内部情况
              /*  for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                   System.out.println("第"+i+"个key : "+entry.getKey()+", Value: "+entry.getValue());
                }*/
            }
        }
        // 条件2：2、在a l , a l+1,...ar中，存在一个数至少出现了 t 次。
        //map.entrySet:
        //Map.Entry 类可以返回所有key，Value
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            /** 此时输出语句如下，每个Value存储 区间中相同次数的个数
             * key : 1, Value: 2
             * key : 1, Value: 3
             * key : 1, Value: 2
             */
            //System.out.println("key : "+entry.getKey()+", Value: "+entry.getValue());

            if (entry.getValue() >= t) {
                return 1;
            }
        }


        return 0;
    }

}
