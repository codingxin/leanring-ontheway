package com.codingzx.leetcode.company.华为;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author codingzx
 * @description a[0] =  1
 * a[1] =  11
 * a[2] =  21
 * a[3] =  1211
 * a[4] =  111221
 * a[5] =  312211
 * @date 2021/4/10 21:03
 */
public class hello_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            if (n == 0) System.out.println(1);
            int[] a = new int[n + 1];
            a[0] = 1;
            for (int i = 1; i <= n; i++) {
                String prenumber = String.valueOf(a[i - 1]);
                System.out.println("当前处理字符串" + prenumber);
                a[i] = Integer.valueOf(chulicurnumber2(prenumber));
            }
            System.out.println(a[n]);
        }
    }

    //  1  2  1  1
    public static String chulicurnumber2(String prenumber) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        stack.add(prenumber.charAt(0));
        for (int i = 1, length = prenumber.length(); i < length; i++) {
            char curchar = prenumber.charAt(i);
            if (stack.contains(curchar)) {
                stack.add(curchar);
            } else {
                // 清除栈中数据
                sb.append(stack.size() + "" + stack.pop());
                stack = new Stack<>();
                stack.add(curchar);
            }
        }
        if (!stack.isEmpty()) {
            sb.append(stack.size() + "" + stack.pop());
        }
        return sb.toString();
    }


    /**
     * 根据前一个数字构建
     *
     * @param prenumber
     * @return
     */
    public static String chulicurnumber(String prenumber) { // 2  1   ->> 1 2 1 1 ->>  1 1  1 2 2 1
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        stack.add(prenumber.charAt(0));
        if (prenumber.length() == 1) {
            sb.append(prenumber.charAt(0) + "" + 1);
            return sb.toString();
        }
        for (int i = 1; i < prenumber.length(); i++) {
            //  1  2   1   1
            char c = prenumber.charAt(i);
            if (stack.contains(c)) {
                stack.add(c);
            } else {
                sb.append(stack.size() + "" + (stack.get(0)));
                stack = new Stack<>();
                // 最关键 加入下一次的起始字母
                stack.add(prenumber.charAt(i));
            }
        }
        // 防止 最后退出的 堆栈 还有数据
        if (!stack.isEmpty()) {
            sb.append(stack.size() + "" + (stack.get(0)));
        }

        return sb.toString();
    }


}
