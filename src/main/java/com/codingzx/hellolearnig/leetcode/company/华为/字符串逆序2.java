package com.codingzx.hellolearnig.leetcode.company.华为;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author created by zhangxin27695
 * @Classname 字符串逆序2
 * @Description 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。 如：输入“I am a student”，输出“student a am I”。
 * @Date 2020-07-16 19:03
 */
public class 字符串逆序2 {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//
//        }
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String input = bufferedReader.readLine();
        StringBuffer sb = new StringBuffer("I am a stude 21nt   ");
        sb.append(" ");
        Stack<String> strstack = new Stack<>();
        StringBuffer tmp = new StringBuffer("");
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ') {
                tmp.append(sb.charAt(i));
            } else {
                strstack.add(tmp.toString());
                tmp = new StringBuffer("");
            }
        }
//        for (String iterator : strstack) {
//            System.out.print(iterator);
//        }
        while (strstack.size() != 0) {
            System.out.print(strstack.pop() + " ");
        }


//        System.out.println(sb.reverse());
    }
}
