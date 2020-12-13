package com.codingzx.leetcode.剑指offer;

/**
 * @author created by zhangxin27695
 * @Classname
 * @Description 5
 * 1+1+1+1+1
 * 1+1+2+1
 * 1+1+1+2
 * 1+2+1+1
 * 1+2+2
 * 2+1+1+1
 * 2+1+2
 * 2+2+1
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @Date 2020-07-07 19:35
 */
public class _8跳台阶 {
    static int count = 0;

    public static int JumpFloor(int target) {
        if (target == 0) {
            count++;
            return 0;
        }
        if (target < 0) return 0;
        JumpFloor(target - 1);
        JumpFloor(target - 2);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(5));

    }
}
