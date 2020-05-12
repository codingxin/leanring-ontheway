package com.codingzx.hellolearnig.leetcode.leetcode.初级算法.Array;

import java.util.Arrays;

/**
 * @author created by zhangxin27695
 * @Classname _283移动零
 * @Description 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @Date 2019-11-19 9:59
 */
public class _283移动零 {
    /**
     * 错误解法 部分案例通过 15 pass /6 fail
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int tmp = 0;
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count += 1;
            }
        }
        for (int i = 0; i < nums.length; i++,k++) {
            if (i<=(i + count) % (nums.length)) {
                tmp = nums[(i + count) % (nums.length)];
                nums[(i + count) % (nums.length)] = nums[i];
                nums[i] = tmp;
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        //记录非o元素开始位置  1 0 0 12 3
        int k = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                //先存储 非0的值
                nums[k++]=nums[i];
            }
        }
        while(k<nums.length){
            nums[k++]=0;
        }
    }

    public static void main(String[] args) {
        int[] a= {1,0,0,3,12};
        moveZeroes2(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
