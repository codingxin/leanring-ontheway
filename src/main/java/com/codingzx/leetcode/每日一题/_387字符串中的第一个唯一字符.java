package com.codingzx.leetcode.每日一题;

import java.util.HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author codingzx
 * @description 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/23 21:35
 */
public class _387字符串中的第一个唯一字符 {
    /**
     * 通过部分用例
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (c == s.charAt(j)) {
                    break;
                }
                if (j == s.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int firstUniqChar1(String s) {
        Map<Character, Integer> chrmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (chrmap.get(ch) != null) {
                chrmap.put(ch, chrmap.get(ch) + 1);
            } else {
                chrmap.put(ch, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (chrmap.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar1("loveleetcode"));
    }

}
