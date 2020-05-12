package com.codingzx.hellolearnig.leetcode.leetcode.初级算法.Array;

import java.util.TreeSet;

/**
 * @author created by zhangxin27695
 * @Classname 存在重复元素III
 * @Description 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * TODO
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019-11-11 10:30
 */
public class 存在重复元素III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < i + k; j++) {

            }
        }
        return true;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        int len = nums.length;
        // 特判
        if (len == 0 || k <= 0 || t < 0) {
            return false;
        }

        // 泛型类型为 Long 是提交失败以后看到测试用例以后改的
        TreeSet<Long> set = new TreeSet<>();

        // 一个一个加进去
        for (int i = 0; i < len; i++) {
            // 检测逻辑 1：以当前数为中心，向左边扩展，看看 set 里有没有大于等于 nums[i] - t 的元素
            // 大于等于 nums[i] - t ，在这个数上面，故使用天花板函数 ceiling
            Long ceiling = set.ceiling((long) nums[i] - t);
            // 在 nums[i] 为中心，半径为 t 的左边有元素，因此直接返回 true 即可
            if (ceiling != null && ceiling <= nums[i]) {
                return true;
            }

            // 检测逻辑 2：以当前数为中心，向左边扩展，看看 set 里有没有小于等于 nums[i] + t 的元素
            // 小于等于 nums[i] + t ，在这个数下面，故使用地板函数 floor
            Long floor = set.floor((long) nums[i] + t);
            // 在 nums[i] 为中心，半径为 t 的右边有元素，因此直接返回 true 即可
            if (floor != null && floor >= nums[i]) {
                return true;
            }

            set.add((long) nums[i]);
            // 当 k = 3 时，[0,1,2,3,4]，i = 3 的时候就要把 i = 0 删掉了
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        // 遍历以后都找不到符合题意的数据对，就只能返回 False
        return false;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 1};
        int a2[] = {1, 0, 1, 1};
        int a3[] = {1, 2, 3, 1, 2, 3};

    }
}
