package com.codingzx.deke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
1.输入字符串s输出s中包含所有整数的最小和，
说明：1字符串s只包含a~z,A~Z,+,-，
2.合法的整数包括正整数，一个或者多个0-9组成，如：0,2,3,002,102
3.负整数，负号开头，数字部分由一个或者多个0-9组成，如-2,-012,-23,-00023
输入描述：包含数字的字符串
输出描述：所有整数的最小和
示例：
  输入：
    bb1234aa
　输出
    10
　输入：
    bb12-34aa
　输出：
    -31
说明：1+2-(34)=-31
 */
public class Hello_82 {

    public static void main(String[] args) {

        String str = "bb1234aa";
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int cur = str.charAt(i);

            if (cur == '-') {
                int start = ++i;
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    i++;
                }
                String substring = str.substring(start, i);
                if (substring.length() > 0) {
                    sum -= Integer.parseInt(substring);
                }

            }
            if (Character.isDigit(cur)) {
                sum += Character.digit(cur, 10);
            }

        }
        System.out.println(sum);

    }

}
