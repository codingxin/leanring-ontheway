package com.codingzx.hellolearnig.leetcode.hello01.java基础;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//  aaa bb  ababa  5
//  wwb    输出  wbw 3

public class Wangyi {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        //保存字符串每个字符
        List<Character> list = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {  //保存每一个字符
            list.add(s.charAt(i));
        }

        for (int i = 0; i < list.size(); i++) {  //保存每一个字符
            System.out.println("取得list 数据为："+list.get(i));
        }
        int k=list.size();
        for (int i = 0; i < k; i++) {
            //把第i个字母从list取出来放进stringBuffer
            if (i == 0) {
                stringBuffer.append(list.get(0));
                list.remove(0);
                System.out.println("list的大小1:"+list.size());
                System.out.println(stringBuffer.toString());
             } else {
                for (int j = 0;;j++) {
                    //把list里面的字符全部取出来放进去j
                    if (list.get(j) != stringBuffer.charAt(i-1) && list.get(i) != null) {
                        stringBuffer.append(list.get(j));
                        list.remove(j);
                        System.out.println("list的大小2:"+list.size());
                    }
                    if (list.isEmpty()) break;
                   // if(j>list.size())

                }
            }
        }
        for(int i=0;i<stringBuffer.length();i++){

            System.out.println(stringBuffer.charAt(i));
        }
        System.out.println(stringBuffer.length());
    }


}
