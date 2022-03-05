package com.codingzx.deke.review;

import java.util.Scanner;

/**
 * @author codingzx
 * @description
 * @date 2022/3/5 10:48
 */
public class 统计含4的数 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(getCount(n));

        }

    }

    public static int getCount(int N) {
        int num = N, k = 0, j = 1, temp = 0;
        while (N > 0) {
            if (N % 10 > 4) {
                temp += (N % 10 - 1) * k + j;
            } else {
                temp += (N % 10) * k;
            }
            k = k * 9 + j;
            j *= 10;
            N /= 10;

        }

        return num - temp;
    }


}
