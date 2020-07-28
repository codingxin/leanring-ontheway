package com.codingzx.leetcode.剑指offer;

import java.util.Arrays;

/**
 * @author created by zhangxin27695
 * @Classname _6旋转数组的最小数字
 * @Description
 * @Date 2020-07-07 19:35
 */
public class _6旋转数组的最小数字 {
    public static int minNumberInRotateArray(int [] array) {
      int min=1000000000;
      for(int i=0;i<array.length; i++){
          min=min>array[i]?array[i]:min;
      }
      return min;
    }
    public static int minNumberInRotateArray2(int [] array) {
        Arrays.sort(array);
        return array[0];
    }
    public static void main(String[] args) {
        int a[]={6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,
                1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        System.out.println(minNumberInRotateArray(a));
        System.out.println(minNumberInRotateArray2(a));

    }
}
