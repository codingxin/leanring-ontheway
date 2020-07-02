package com.codingzx.hellolearnig.排序算法;

/**
 * @author codingzx
 * @description
 * @date 2020/5/21 19:26
 */
public class 冒泡查找 {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 8, 9, 20};
        System.out.println(binarySearch(a, 9));
    }

    public static int[] binarySearch(int[] a, int n) {
    int i=0,j=0,k=0;
    for(;i<a.length;i++){
        for(j=1;j<a.length;j++){
            if(a[i]<a[j]){
                int b=a[i];
                a[i]=a[j];
                a[j]=b;
            }
        }
    }
    return a;
    }
}
