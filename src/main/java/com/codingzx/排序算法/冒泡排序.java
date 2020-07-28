package com.codingzx.排序算法;

import java.util.Arrays;

/**
 * @author codingzx
 * @description
 * @date 2020/5/21 19:26
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 8, 9, 20,4};
        System.out.println(Arrays.toString(binarySearch(a)));
    }

    public static int[] binarySearch(int[] a) {
    for(int i=0;i<a.length;i++){
        for(int j=i+1;j<a.length;j++){
            if(a[i]>a[j]){
                int b=a[i];
                a[i]=a[j];
                a[j]=b;
            }
        }
    }
    return a;
    }
}
