package com.codingzx.正则练习;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 进阶 {


    public static void main(String[] args) {
        /**
         *    [0-9a-fA-F]{6}   匹配6位由0~9数字和a~f和A~F组成的字符串
         *    [^a-f] 排除a-f组成的字符串
         *    | 或规则匹配  AB|CD可以匹配AB或者CD
         *    String regex=“learn\\s(java|php|go)” 匹配learn java或者learn php 或者learn go，\s代表匹配空格
         */
        Pattern p = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher m = p.matcher("010-12345678");
        if (m.matches()) {
            String g1 = m.group(1);
            String g2 = m.group(2);
            System.out.println(g1);
            System.out.println(g2);
        } else {
            System.out.println("匹配失败!");
        }


        /**
         * 正则默认表示贪婪匹配
         * \d+ 后面加上？ 表示非贪婪匹配，避免+把后面0匹配了
         *
         * 我们再来看这个正则表达式(\d??)(9*)，注意\d?表示匹配0个或1个数字，后面第二个?表示非贪婪匹配，
         * 因此，给定字符串"9999"，匹配到的两个子串分别是""和"9999"，
         * 因为对于\d?来说，可以匹配1个9，也可以匹配0个9，但是因为后面的?表示非贪婪匹配，它就会尽可能少的匹配，结果是匹配了0个9。
         */
        Pattern pattern2 = Pattern.compile("(\\d+?)(0*)");
        Matcher matcher = pattern2.matcher("1230000");
        if (matcher.matches()) {
            System.out.println("group1=" + matcher.group(1)); // "123"
            System.out.println("group2=" + matcher.group(2)); // "0000"
        }


        /**
         * 匹配替换 replaceAll
         */

        String s = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
        String r = s.replaceAll("\\s+", " ");
        System.out.println(r); // "The quick brown fox jumps over the lazy dog."

        /**
         * 反相匹配（查找到字符串然后再引用） 给4位子串加标签
         */
        String s2 = "the quick brown fox jumps over the lazy dog.";
        String r2 = s2.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
        System.out.println(r2);










    }


}
