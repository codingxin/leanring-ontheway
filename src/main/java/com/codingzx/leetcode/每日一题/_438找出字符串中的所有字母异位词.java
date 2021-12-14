package com.codingzx.leetcode.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author codingzx
 * @description
 * @date 2021/11/28 12:08
 */
public class _438找出字符串中的所有字母异位词 {


    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int m = p.length();

        for (int i = 0; i <= n - m; i++) {
            if (CompareTwoString(s, i, p)) result.add(i);
        }
        return result;
    }


    // 错误的方法
    public static boolean CompareTwoString(String s, int start, String p) {
        int n = p.length();
        // 比较 start~ start+n 的 字符串 和 p 是否相同
        String tmp = s.substring(start, start + n);
//        System.out.println("获取的子串为" + tmp);
//        System.out.println("需要比较的子串为" + p);
        if (tmp == p) return true;
        // 处理 两个字符串各不相同的情况
        int tmpresult = tmp.charAt(0);
        for (int i = 1; i < n; i++) {
            tmpresult ^= tmp.charAt(i);
        }
        int presult = p.charAt(0);
        for (int i = 1; i < n; i++) {
            presult ^= p.charAt(i);
        }
        if (tmpresult == presult && tmpresult == 0) {
            return false;
        }

        return (tmpresult ^ presult) == 0 ? true : false;

    }


    public static void main(String[] args) {
        String a = "af";
        String b = "be";
        System.out.println(findAnagrams(a, b));


    }


}
