package com.codingzx.hellolearnig.leetcode.company.华为;

import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname 求字符串最后一个单词长度
 * @Description 计算字符串最后一个单词的长度，单词以空格隔开。
 * @Date 2020-07-16 16:23
 */
public class 求字符串最后一个单词长度 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        while(input.hasNext()){
            String[] str=input.nextLine().split(" ",-1); // -1 不处理尾部空格
            System.out.println(str[str.length-1].length());
        }
    }
}
