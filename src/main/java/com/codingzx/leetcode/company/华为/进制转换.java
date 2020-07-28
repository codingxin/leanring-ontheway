package com.codingzx.leetcode.company.华为;

import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname 进制转换
 * @Description 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 * @Date 2020-07-16 16:41
 */
public class 进制转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(fun(str.substring(2)));  //取出0X13111 中的13111
        }
    }

    public static int fun(String s) {
        int n=0;
        int count= 0;
        int temp = 0;
        char ch;
        while(count<s.length())
        {
            ch=s.charAt(s.length()-count-1); // s.lenth =5  count =0  取最后一位
            if(ch>='0'&&ch<='9'){
                temp = ch-'0';
            }else if(ch>='A'&&ch<='Z'){
                temp = ch-'A'+10;
            }else if(ch>='a'&&ch<='z'){
                temp = ch-'a'+10;
            }else{
                break;
            }
            n += temp*Math.pow(16,count);
            count++;
        }



        return n;
    }
}
