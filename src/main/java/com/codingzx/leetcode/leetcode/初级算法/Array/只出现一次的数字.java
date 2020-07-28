package com.codingzx.leetcode.leetcode.初级算法.Array;

import java.util.HashSet;

/**
 * @author created by zhangxin27695
 * @Classname 只出现一次的数字
 * @Description
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @Date 2019-11-11 19:26
 */
public class 只出现一次的数字 {
    public static int singleNumber(int[] nums) {
        int k=0;
        //异或运算
        for(int i=0;i<nums.length;i++){
            k^=nums[i];
        }
        return k;
    }

    public static int singleNumber2(int[] nums) {
        int cn = nums[0];
        if (nums.length == 1) {
            return cn;
        }

        for (int i = 1; i < nums.length; i = i + 2) {
            cn = cn ^ nums[i] ^ nums[i + 1];
        }
        return cn;
    }
    public static int singleNumber3(int[] nums) {
        HashSet<Integer> setsingle=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(setsingle.contains(nums[i])){
                setsingle.remove(nums[i]);
            }
            else{
                setsingle.add(nums[i]);
            }
        }
        for(Integer i:setsingle){
            return  i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int a[] = {1,2,3,1};
        int a2[] ={1,0,1,1};
        int a3[] ={1,2,3,1,2,3,7};
        System.out.println(singleNumber3(a3));
    }
}
