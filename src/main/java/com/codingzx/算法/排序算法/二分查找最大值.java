package com.codingzx.算法.排序算法;

/**
 * @author codingzx
 * @description 时间复杂度：最坏 O(log2 N)
 * 最好 O（1）
 * 空间复杂度： O（1）
 * @date 2020/5/21 19:10
 */
public class 二分查找最大值 {
    public static void main(String[] args) {
        int[] a = new int[50];
        int j = 0;
        for (int i = 0; i < 50; i++) {
            a[i] = ++j;
        }
        System.out.println(binarySearch(a, 24));
    }

    public static int binarySearch(int[] a, int n) {
        int l = 0, h = a.length - 1;
        int sum = 0;
        while (l <= h) {
            //int mid = (l + h) / 2;  防止整型溢出
            int mid = l + (h - l) / 2;
            int max = h;
            if (h+1  % 2 != 0) {
                max = h;
                if (a[max] == n) {
                    sum++;
                    System.out.println("结果是" + sum);
                    return sum;
                }
            }
            if(panduan(a,l,mid)<panduan(a,mid,h)){
                h=mid;
            }else{
                l=mid;
            }
            sum++;
        }
        return -1; //没有找到这个元素
    }

    public static int panduan(int a[],int l,int mid){
        int sum=0;
        for(int i=l;i<=mid;i++){
            sum+=a[i];
        }
        return sum;



    }

}
