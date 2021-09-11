package com.codingzx.leetcode.leetcode.初级算法.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author created by zhangxin27695
 * @Classname _1两数之和
 * @Description 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020-05-18 9:17
 */
public class _1两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
//        for (Map.Entry e : map.entrySet()) {
//            System.out.println(e.getKey() + "Start" + e.getValue());
//        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return a;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 11, 15};
        int targer = 9;
        int[] a = new int[2];
        twoSum(nums, targer);
        int c = 8;
        System.out.println((c != 3 && c != 4 && c != 5 && c != 6));


    }
}
