package com.codingzx.leetcode.company.华为;

import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname 计算字符串个数
 * @Description 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，
 * 然后输出输入字符串中含有该字符的个数。不区分大小写
 * @Date 2020-07-16 16:28
 */
public class 计算字符串个数 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String cha = input.nextLine();
        int count = 0;
        if (str != null && str.length() > 0) {
            for (int i = 0; i < str.length(); i++) {
                if (cha.toLowerCase().charAt(0) == str.toLowerCase().charAt(i)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
