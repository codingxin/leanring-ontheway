package com.codingzx.leetcode.company.华为;

import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname 求最大公约数
 * @Description   求最小公倍数 = 两数乘积 / 两数最大公约数
 * int a b
 *  tmp = a%b;
 *  a=b;
 *  b=tmp;
 *
 * @Date 2020-07-16 17:14
 */
public class 求最大公约数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        // int j = a * b;
        if (a < b) {    // 保证 a》b，第一个数大于第二个数
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            int r = a % b;  // r 存 a%b的余数
            a = b;          // a第一个数 取第二个数   a 80   60  20
            b = r;          // b第二个数取余数        b 60   20   0
        }
       System.out.println(a);
    }
}
