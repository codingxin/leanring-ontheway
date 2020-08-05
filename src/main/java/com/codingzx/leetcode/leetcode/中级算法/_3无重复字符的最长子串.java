package com.codingzx.leetcode.leetcode.中级算法;

import java.util.HashSet;
import java.util.Set;

/**
 * @author created by zhangxin27695
 * @Classname _3无重复字符的最长子串
 * @Description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "B"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @Date 2020-05-18 10:22
 */
public class _3无重复字符的最长子串 {
    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int rk = -1; //左指针，初始值为-1，左边界的左端 还没开始移动
        int ans = 0; //记录每个不重复子串的长度
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));// 移除上一次重复的
            }
            while (rk + 1 < s.length() && !occ.contains(s.charAt(rk + 1))) { //循环不重复的子串
                // 不断地移动左指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串,长度为rk-i+1
            ans = Math.max(ans, rk - i + 1);
        }

        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        // 每一次循环不重复的子串长度
        int ans = 0, rk = 0;
//        Set<Character> occ = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
//            if (i != 0) {
//                occ.remove(s.charAt(i - 1));
//            }
            Set<Character> occ = new HashSet<>();
            while (rk < s.length() && !occ.contains(s.charAt(rk))) {
                occ.add(s.charAt(rk));
                rk++;
            } // i 0  k 2
            //  2   5
            ans = Math.max(ans, rk - i);
        }

        return ans;

    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("_3无重复字符的最长子串长度为" + lengthOfLongestSubstring(s));
    }
}
