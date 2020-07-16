package com.codingzx.hellolearnig.leetcode.company.华为;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname 字符串逆序
 * @Description 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。 如：输入“I am a student”，输出“tneduts a ma I”。
 * @Date 2020-07-16 18:47
 */
public class 字符串逆序 {

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//
//        }
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String input=bufferedReader.readLine();
        StringBuffer sb=new StringBuffer(input);
        System.out.println(sb.reverse());
    }


}
