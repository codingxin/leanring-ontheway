package com.codingzx.hellolearnig.leetcode.leetcode.初级算法;

import java.util.Arrays;

/**
 * @author created by zhangxin27695
 * @Classname _169求众数
 * @Description
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * @Date 2019-11-19 13:56
 */
public class _169求众数 {
    public static int majorityElement(int[] nums) {
        int count=1;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1; i++){
            if(nums[i]==nums[i+1]) {
                count++;
            }
            if(count>nums.length/2){
                return nums[i];
            }
            if(nums[i]!=nums[i+1]){
                count=1;
            }
        }
        return nums[nums.length -1];
    }

    public static void main(String[] args) {
        int a[] = {2,2,1,1,1,2,2};
        int a2[] = {3,2,3};
        int a3[] = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
//        numberOfSubarrays(a, 3);
        System.out.println("这个数组" + majorityElement(a2));
    }


}
