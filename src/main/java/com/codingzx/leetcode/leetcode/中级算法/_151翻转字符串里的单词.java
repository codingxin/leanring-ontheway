package com.codingzx.leetcode.leetcode.中级算法;

import java.util.Stack;

/**
 * @author created by zhangxin27695
 * @Classname _151翻转字符串里的单词
 * @Description 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  Start world!  "
 * 输出: "world! Start"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019-11-20 16:04
 */
public class _151翻转字符串里的单词 {
    public static void main(String[] args) {
        String s = "a good   example";
        short s1 = 1;
        s1 = (short) (s1 + 1);
        s1 += 1;
        System.out.println("这个字符串" + reverseWords3(s));
    }

    /**
     * 反转数组
     *
     * @param chas
     * @param from
     * @param to
     */
    private static void reverseString(char[] chas, int from, int to) {
        while (from < to) {
            char temp = chas[from];
            chas[from++] = chas[to];
            chas[to--] = temp;
        }
    }

    public static String reverseWords(String s) {
        char[] strarray = s.toCharArray();
        reverseString(strarray, 0, strarray.length - 1);
        int begin = 0;
        //读到空格，翻转begin到空格前一个位置的字符（i-1），翻转结束后将空格后一个位置的值（i+1）赋给begin
        for (int i = 1; i < strarray.length; i++) {
            if (strarray[i] == ' ') {
                reverseString(strarray, begin, i - 1);
                begin = i + 1; //保存字母起始下标
            }
        }

        if (begin < strarray.length) {
            reverseString(strarray, begin, strarray.length - 1);
        }
        return s.toString();
    }

    public static String reverseWords2(String s) {
        Stack<String> stack = new Stack<>(); //栈后进先出
        StringBuilder temp = new StringBuilder();
        s += " ";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (temp.length() != 0) {
                    stack.push(temp.toString());
                    temp = new StringBuilder();  //每次只放一个单词进去
                }
            } else {
                temp.append(s.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        res.append(stack.pop()); //
        while (!stack.isEmpty()) {
            res.append(" ");
            res.append(stack.pop());
        }
        return res.toString();
    }

    public static String reverseWords3(String s) {
        String emptyStr = " ";
        //trim()方法返回调用字符串对象的一个副本，但是所有起始和结尾的空格都被删除了，
        //split 将一个字符串分割为子字符串，然后将结果作为字符串数组返回。
        final String[] s1 = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            String str = s1[i];
            while (str.contains(emptyStr)) {
                str = str.replaceAll(emptyStr, "");
            }
            if (" ".equals(str)) {
                continue;
            }
            sb.append(str);
            if (i != 0) {
                sb.append(emptyStr);
            }
        }
        return sb.toString();
    }
}
