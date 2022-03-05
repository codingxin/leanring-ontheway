package com.codingzx.deke;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
  在学校中
  N个小朋友站成一队
  第i个小朋友的身高为height[i]
  第i个小朋友可以看到第一个比自己身高更高的小朋友j
  那么j是i的好朋友
  (要求：j>i)
  请重新生成一个列表
  对应位置的输出是每个小朋友的好朋友的位置
  如果没有看到好朋友
  请在该位置用0代替
  小朋友人数范围 0~40000

  输入描述：
    第一行输入N
    N表示有N个小朋友

    第二行输入N个小朋友的身高height[i]
    都是整数

  输出描述：
    输出N个小朋友的好朋友的位置

  示例1：
     输入：
       2
       100 95
      输出
       0 0
     说明
       第一个小朋友身高100站在队伍末尾
       向队首看 没有比他身高高的小朋友
       所以输出第一个值为0
       第二个小朋友站在队首前面也没有比他身高高的小朋友
       所以输出第二个值为0

   示例2：
      输入
        8
        123 124 125 121 119 122 126 123
      输出
        1 2 6 5 5 6 0 0
       说明：
       123的好朋友是1位置上的124
       124的好朋友是2位置上的125
       125的好朋友是6位置上的126
        依此类推

   */
public class Hello_76 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        if (n == 0) {
//            System.out.println(0);
//            return;
//        }
//        String[] strs = scanner.nextLine().split(" ");
        String[] strs = "123 124 125 121 119 122 126 123".split(" ");
        int length = strs.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 0);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                System.out.println("比较的第一个元素为" + strs[i] + "  ，   比较的第二个元素为 " + strs[j]);
                if (Integer.parseInt(strs[j]) > Integer.parseInt(strs[i])) {
                    dp[i] = j;
                    break;
                }
            }
        }
        for (Integer i : dp) {
            System.out.println("数组元素" + i);
        }
    }


}
