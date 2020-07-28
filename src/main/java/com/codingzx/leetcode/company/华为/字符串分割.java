package com.codingzx.leetcode.company.华为;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname 字符串分割
 * @Description 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；  aabbbcccc|ccc|
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * @Date 2020-07-16 16:37
 */
public class 字符串分割 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                while (str.length() >= 8) {
                    System.out.println(str.substring(0, 8));
                    str=str.substring(8);
                }
                if (str.length() < 8 && !"".equals(str)) {
                     str+="0000000000";
                    System.out.println(str.substring(0, 8));
                }


            }


        }


    }


    public static void main2(String[] args) throws IOException {
        BufferedReader bufrd = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = bufrd.readLine()) != null) {
            int count = Integer.parseInt(input);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < count; i++) {
                input = bufrd.readLine();
                int start = 0;
                int end = 8;
                int length = input.length() / 8;     // 有几个 8 ，
                if (input.length() % 8 > 0) {   // 最后一个凑8
                    length++;
                }
                for (int j = 0; j < length; j++) {  // 拼凑length个子串
                    if (end > input.length()) {
                        end = input.length();
                    }
                    String current = input.substring(start, end);
                    result.append(current);
                    if (current.length() < 8) System.out.println(1);
                    for (int k = 0; k < 8 - current.length(); k++) {
                        result.append("0");
                    }
                    result.append("\n");
                    start += 8;
                    end += 8;
                }
            }
            System.out.println(result.toString().trim());

        }

    }

}
