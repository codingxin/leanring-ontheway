package com.codingzx.正则练习;

public class 基础 {


    public static void main(String[] args) {

        String regex = "\\d{4}"; // 匹配4位数字，\d代表单个数字
        System.out.println("2019".matches(regex));


        String regex1 = "a.c"; // .代表任意字符 可用equal代替
        System.out.println("a&c".matches(regex1));


        String regex2 = "123\\w"; // \w代表单个字符，数字，下划线  [A-Za-z0-9_]
        System.out.println("123_".matches(regex2));


        String regex3 = "a\\sc"; // \s代表单个空格   \S 匹配非空字符
        System.out.println("a c".matches(regex3));


        String regex4 = "\\D{4}";   // \D代表非数字
        System.out.println("qwer".matches(regex4));

        /**
         *              *可以匹配任意个字符，包括0个字符
         *              +匹配至少一个字符
         *              ?匹配0个或一个字符
         *              {n}精确匹配n个
         *              {n,m}模糊匹配n~m个
         */
        String regex5 = "a\\d*"; // \d* 匹配任意个数字，包括0个
        System.out.println("a".matches(regex5));


















    }
}
