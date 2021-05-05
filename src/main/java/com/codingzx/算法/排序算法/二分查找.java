package com.codingzx.算法.排序算法;

/**
 * @author codingzx
 * @description 时间复杂度：最坏 O(log2 N)
 * 最好 O（1）
 * 空间复杂度： O（1）
 * @date 2020/5/21 19:10
 */
public class 二分查找 {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 8, 9, 20};
        System.out.println(binarySearch(a, 9));
    }

    public static int binarySearch(int[] a, int n) {
        int l = 0, h = a.length - 1;
        while (l <= h) {
            //int mid = (l + h) / 2;
            int mid = l + (h - l) / 2;  //  防止整型溢出
            if (a[mid] == n) {
                return mid;
            } else if (a[mid] < n) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1; //没有找到这个元素
    }

}
