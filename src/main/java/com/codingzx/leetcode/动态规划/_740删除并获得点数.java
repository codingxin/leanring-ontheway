package com.codingzx.leetcode.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * @author codingzx
 * @description 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：3  22 4
 * 3  3
 * 3
 * 3
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 * @date 2021/5/5 11:30
 */
public class _740删除并获得点数 {

    // 传入当前下标，计算其他元素

    /**
     * @param numCount 当前dp数组
     * @param i        当前下标
     * @param count    当前结果
     * @return
     */
    public Integer findMax(Map<Integer, Integer> numCount, int i, int count) {


        return count;
    }


    // dp删除当前元素的点数
    public static int deleteAndEarn(int[] nums) {
        if (nums.length == 1) return nums[0];
        int maxVal = 0;
        for (int tmp : nums) {
            // 找到最大的元素
            maxVal = Math.max(tmp, maxVal);
        }
        int[] dp = new int[maxVal + 1];
        // 2 2 3 3 3 4
        // 0 0 4 9 4
//        for (int i = 0; i < nums.length; i++) {
//            dp[nums[i]] += nums[i];
//        }
        for (int val : nums) {
            dp[val] += val;
        }

        return rob(dp);
    }

    public static int rob(int[] nums) {
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return second;
    }


    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(deleteAndEarn(nums));

    }


}
