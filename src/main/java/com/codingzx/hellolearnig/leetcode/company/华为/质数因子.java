package com.codingzx.hellolearnig.leetcode.company.华为;

import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname 质数因子
 * @Description 输入一个正整数，按照从小到大的顺序输出它的所有质因子（如180的质因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 * @Date 2020-07-16 16:47
 */
public class 质数因子 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            if(n==1){
                System.out.println("1");
                continue;
            }
            int tmp = 2;
            while (n != 1) {
                if (n % tmp == 0) {
                    System.out.print(tmp + " ");
                    n /= tmp;
                } else {
                    tmp += 1;
                }
            }

        }
    }
}
