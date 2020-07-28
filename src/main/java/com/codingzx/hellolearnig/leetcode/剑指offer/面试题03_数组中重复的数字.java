package com.codingzx.hellolearnig.leetcode.剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author created by zhangxin27695
 * @Classname 面试题03_数组中重复的数字
 * @Description
 * （1）遍历数组，将每个数字放入其数据本身大小的那个位置，然后将那个位置的数字放回，也就是交换arr[i]和arr[arr[i]]【以空间换时间】
 * （2）如果arr[i]!=arr[arr[i]]，可以成功交换，则继续执行（1）
 * （3）则该位置已有本数据（重复），结束，返回该重复值。
 * @Date 2020-07-27 19:23
 */
public class 面试题03_数组中重复的数字 {

    public static void main(String[] args) {

    }


    public int findRepeatNumber(int[] arr) {
        for(int i=0;i<arr.length;i++){
            while(arr[i]!=i){
                if(arr[i]==arr[arr[i]]) return arr[i];
                int t = arr[i];
                arr[i] = arr[t];
                arr[t] = t;
            }
        }
        return -1;
    }
    public int findRepeatNumber2(int[] arr) {
        Set<Integer> intSet=new HashSet<>();
        for(int i:arr){
            if(intSet.contains(i)){
               return i;
            }
        }
        return -1;

    }
}
