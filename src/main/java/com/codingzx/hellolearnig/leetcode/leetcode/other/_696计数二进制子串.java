package com.codingzx.hellolearnig.leetcode.leetcode.other;

/**
 * @author created by zhangxin27695
 * @Classname _696计数二进制子串
 * @Description
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 * 示例 1 :
 *
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 *
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 *
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * 注意：
 *
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 * TODO
 * @Date 2019-11-18 9:30
 * 思路： 1. 求子串，必须是双数  2. 0和1 数目相等
 */
public class _696计数二进制子串 {
    public static int countBinarySubstrings(String s) {
    int count=0;


    return count++;
    }
    public static void main(String[] args) {
        String str="00110011";
        System.out.println("这个数组" + countBinarySubstrings(str));
    }
}
