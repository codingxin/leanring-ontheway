package com.codingzx.hellolearnig.leetcode.company.华为;

import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname 字符串分割
 * @Description 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；  aabbbcccc|ccc|
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * @Date 2020-07-16 16:37
 */
public class 字符串分割 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String str=input.nextLine();
            while(str.length()>=8){
                System.out.println(str.substring(0,8));
                str=str.substring(8);
            }
            if(str.length()<8&&str!=null){
                str=str+"00000000";
                System.out.println(str.substring(0,8));
            }
        }










    }


}
