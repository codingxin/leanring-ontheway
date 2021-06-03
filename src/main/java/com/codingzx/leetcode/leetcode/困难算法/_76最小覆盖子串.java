package com.codingzx.leetcode.leetcode.困难算法;

import java.util.HashMap;
import java.util.Map;

/**
 * @author codingzx
 * @description
 * @date 2021/5/30 16:47
 */
public class _76最小覆盖子串 {
    static Map<Character, Integer> strMap = new HashMap<>();
    static Map<Character, Integer> sonMap = new HashMap<>();

    public static String minWindow(String s, String t) {
        int sonLenth = t.length();
        for (int i = 0; i < sonLenth; i++) {
            char c = t.charAt(i);
            sonMap.put(c, sonMap.getOrDefault(c, 0) + 1);
        }
        int ansL = -1, ansR = -1;
        int resultLength = Integer.MAX_VALUE;
        int l = 0, r = -1;
        int sLength = s.length();
        while (r < sLength) {
            r++;
            if (r < sLength && sonMap.containsKey(s.charAt(r))) {
                char c = s.charAt(r);
                strMap.put(c, strMap.getOrDefault(c, 0) + 1);
            }
            while (check() && l <= r) {
                if (r-l+1 < resultLength) {
                    resultLength = r-l+1;
                    ansL = l;
                    ansR = l + resultLength;
                }
                if (sonMap.containsKey(s.charAt(l))) {
                    char c = s.charAt(l);
                    strMap.put(c, strMap.getOrDefault(c, 0) - 1);
                }
                ++l;
            }
        }
        return ansR == -1 ? "" : s.substring(ansL, ansR);
    }


    public static boolean check() {
        for (Map.Entry<Character, Integer> entry : sonMap.entrySet()) {
            if (entry.getValue() > strMap.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("AABCDO", "ADC"));
        System.out.println(minWindow("ADOBCECODsdsEBfANC", "sBCf"));
    }

}
