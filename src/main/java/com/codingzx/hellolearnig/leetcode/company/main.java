package com.codingzx.hellolearnig.leetcode.company;

import java.util.Stack;

/**
 * @author created by zhangxin27695
 * @Classname main
 * @Description
 * @Date 2019-11-18 19:17
 */
public class main {

    public static void main(String[] args) {

        String s = "HG[3|B[2|CA]]F";
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int num =0;
        StringBuffer sb = new StringBuffer("");
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c<='9'&&c>='0'){
                num=10*num + c-'0';
            }else if(c=='|'){
                numStack.push(num);
                num = 0;
            }else if(c<='Z'&&c>='A'){
                sb.append(c);
            }else if(c=='['){
                strStack.push(sb.toString());//暂存供遇到 ] 时合并生成新的子串
                sb=  new StringBuffer("");;
            }else{
                num = numStack.pop();
                StringBuffer tmp = new StringBuffer(strStack.pop());
                while(num>0){
                    tmp.append(sb.toString());
                    num--;
                }
                sb=new StringBuffer(tmp.toString());
            }

        }
        System.out.println(sb.toString());

    }
}
