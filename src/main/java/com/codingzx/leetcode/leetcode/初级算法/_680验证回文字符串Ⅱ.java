package com.codingzx.leetcode.leetcode.初级算法;

/**
 * @author created by zhangxin27695
 * @Classname _680验证回文字符串Ⅱ
 * @Description 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020-05-19 18:51
 */
public class _680验证回文字符串Ⅱ {
    public static int del = 0;

    public static boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if (del == 0) {
                    del++;
                    return validPalindrome(s.substring(i, j)) || validPalindrome(s.substring(i + 1, j + 1));
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abca";
        System.out.println("_680验证回文字符串Ⅱ" + validPalindrome(s));
    }
}
