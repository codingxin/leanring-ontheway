package com.codingzx.leetcode.leetcode.困难算法;

/**
 * @author created by zhangxin27695
 * @Classname _97交错字符串
 * @Description 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * @Date 2019-11-19 14:42
 */
public class _97交错字符串 {
    public static int cont=0;
    /**
     * 最基本的想法就就是找到所有 S1 和 S2 能够形成的交错字符串。为了实现这样的想法，我们使用回溯。
     * 我们首先将 S1 中的第一个字符作为开始字符，
     * 然后将 S1 字符串剩余部分和 S2 字符串所有可能情况添加在这个字符后面，
     * 每次用完所有字符后检查字符串与 s3s3 是否一致。类似的，我们可以选择 S2 第一个字符作为开始字符，
     * 然后将 S2 剩余字符串和 S1 字符串回溯地添加到该字符后面，看是否能形成 s3
     */
    public static boolean is_Interleave(String s1,int i,String s2,int j,String res,String s3)
    {   _97交错字符串.cont++;  //123次递归调用
        if(res.equals(s3) && i==s1.length() && j==s2.length())
            return true;
        boolean ans=false;
        if(i<s1.length())
            ans|=is_Interleave(s1,i+1,s2,j,res+s1.charAt(i),s3);
        if(j<s2.length())
            ans|=is_Interleave(s1,i,s2,j+1,res+s2.charAt(j),s3);
        return ans;

    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        return is_Interleave(s1,0,s2,0,"",s3);
    }

    public static boolean is_Interleave2(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }
        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }
        if (memo[i][j] >= 0) {
            return memo[i][j] == 1 ? true : false;
        }
        boolean ans = false;
        if (s3.charAt(k) == s1.charAt(i) && is_Interleave2(s1, i + 1, s2, j, s3, k + 1, memo)
                || s3.charAt(k) == s2.charAt(j) && is_Interleave2(s1, i, s2, j + 1, s3, k + 1, memo)) {
            ans = true;
        }
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
    public static  boolean isInterleave2(String s1, String s2, String s3) {
        int memo[][] = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return is_Interleave2(s1, 0, s2, 0, s3, 0, memo);
    }




    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));

    }
}
