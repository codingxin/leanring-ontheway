package com.codingzx.Stream基础使用.testclass;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname 字符串查找
 * @Description 9.怎么去找一个字符串所有以b结尾的子串的长度？ 用lamda表达式写 我不会呀
 * @Date 2020-05-14 16:14
 */
public class 字符串查找 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuffer sb=new StringBuffer(scanner.nextLine());

        String sb = "hello B dcasdwevvvdsdvsadqwdsa B dsbdsab B dsa B da B";
        System.out.println(sb.split("b").length);
        Arrays.stream(sb.split("b")).forEach(e->{
            System.out.println("字串是"+e.toString()+"长度是"+e.length());
        });
        for(String c:sb.split("b")){
            System.out.println(c);
        }
    }
}
