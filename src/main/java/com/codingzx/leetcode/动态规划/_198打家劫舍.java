package com.codingzx.leetcode.动态规划;

/**
 * @author codingzx
 * @description 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @date 2021/5/5 12:02
 */
public class _198打家劫舍 {

    /**
     * 一间房屋 直接偷
     * 两间房屋 取最大的偷
     * ......
     * 第k间房   k-2 + k
     * k-1
     *
     * @param nums
     * @return
     */


    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        int dp[] = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];  // second
    }

    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        int dp[] = new int[length];

        int first = dp[0];
        int second = dp[1];   // 不断前移的指针
       // first second  tmp
        //              second
        //      newvalue
        //second
        for (int i = 2; i < length; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            // first保存 i -2
            first = tmp;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));

    }

}
