package com.codingzx.排序算法;

import java.util.LinkedList;

/**
 * @author created by zhangxin27695
 * @Classname 快排单链表
 * @Description
 * @Date 2020-07-28 14:10
 */
public class 快排单链表 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();
        int[] arr = {4,2,5,3,7,9,0,1}; // test case 1
//      int[] arr = {5,4,3,2,1,6,7,9,8,10}; // test case 2
        for(int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        qsort(list, 0, arr.length-1);
        System.out.println(list.toString());
    }


    public static void swap(LinkedList<Integer> list, int i, int j) {
        int t = list.get(j);
        list.set(j, list.get(i));
        list.set(i, t);
    }

    public static void qsort(LinkedList<Integer> list, int left, int right) {

        if (left < right) {

            int i = left;
            int j = i + 1;
            int x = list.get(i);

            while (j <= right) {
                // 如果j指向的值大于等于基准数字，就继续移动
                while (j <= right && list.get(j) >= x) j++;
                // 找到第一个小于基准的值
                if (j <= right) {
                    i++;
                    swap(list, i, j);
                    j++;
                }
                // 交换i和基准，一趟排序结束
                swap(list, left, i);
                qsort(list, left, i - 1);
                qsort(list, i + 1, right);


            }


        }


    }

}
