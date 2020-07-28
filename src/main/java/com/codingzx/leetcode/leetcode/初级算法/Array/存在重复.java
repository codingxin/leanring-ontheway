package com.codingzx.leetcode.leetcode.初级算法.Array;
import java.util.Arrays;
import	java.util.HashSet;

/**
 * @author created by zhangxin27695
 * @Classname 存在重复
 * @Description
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * @Date 2019-11-11 9:47
 */
public class 存在重复 {

    public static boolean containsDuplicate(int[] nums) {
        if(nums.length==0){
            return false;
        }
        int length=nums.length;
        int count = 1;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j <= length - 1; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count >=2 ? true : false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<> ();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        return set.size()!=nums.length?true:false;
    }

    public static boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int a[] = {1, 1, 5, 3, 1, 1, 2, 4, 1, 7, 8, 8, 999};
        int a2[] ={1,2,3,1};
        int a3[] ={2,2};
        System.out.println(containsDuplicate(a3));
    }
}
