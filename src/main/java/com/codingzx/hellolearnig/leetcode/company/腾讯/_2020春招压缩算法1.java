package com.codingzx.hellolearnig.leetcode.company.腾讯;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author created by zhangxin27695
 * @Classname _2020春招压缩算法1
 * @Description 小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，
 * 对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，例如字符串ABCABCABC将会被压缩为[3|ABC]，
 * 现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
 * <p>
 * 输入描述:
 * 输入第一行包含一个字符串s，代表压缩后的字符串。
 * S的长度<=1000;
 * S仅包含大写字母、[、]、|;
 * 解压后的字符串长度不超过100000;
 * 压缩递归层数不超过10层;
 * <p>
 * 输出描述:
 * 输出一个字符串，代表解压后的字符串。
 * <p>
 * 输入例子1:
 * HG[3|B[2|CA]]F
 * <p>
 * 输出例子1:
 * HG B CACA B CACA B CACA F
 * <p>
 * HG[3|B[2|CA]]F−>HG[3|BCACA]F−>HGBCACABCACABCACAF
 * @Date 2020-07-02 10:38
 */
public class _2020春招压缩算法1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sb = "HG[3|B[2|CA]]F"; //new StringBuffer(scanner.nextLine());

        Stack<Integer> intstatck = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuffer sbtmp = new StringBuffer("");   // 子串/最后返回结果
        StringBuffer sbresult = new StringBuffer("");
        int num = 0; //当前数字
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c <= 'Z' && c >= 'A') {
                sbtmp.append(c);  //  一次循环中子串有 多个字母
            } else if (c <= '9' && c >= '0') {
                // 字母转化成数字
                num = Integer.valueOf(c-'0');
            } else if (c == '[') { // [
                // 开始构建字串 先[ 再到数字 | 字母 最后 】
                strStack.push(sbtmp.toString());
                sbtmp = new StringBuffer("");//清空
            } else if (c == '|') {
                intstatck.add(num); // 数字
                num=0;//清空
            } else if (c == ']') {
                num = intstatck.pop();
                StringBuffer tmp = new StringBuffer(strStack.pop()); // 保存里层的子字符串
                while (num > 0) {
                    //sbtmp.append(tmp);
                    tmp.append(sbtmp.toString());  // 外层的B 循环添加 里层的CA
                    num--;
                }
                sbtmp = new StringBuffer(tmp.toString());
            }
        }
        System.out.println(sbtmp.toString());


    }
}
