package com.codingzx.concurrentThread.TestThread;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author codingzx
 * @description 7   0111  3
 * 8   1000  1
 * @date 2021/5/10 20:32
 */
public class TestHello2 {

    public static int countTriplets(int[] arr) {
        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j; k < n; ++k) {
//                    if (s[i] == s[k + 1]) {
//                        ++ans;
//                    }
                    int a = s[j - 1] ^ s[i - 1];
                    int b = s[k] ^ s[j - 1];
                    if (a == b) ans++;

                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] number = {
                2, 3, 1, 6, 7
        };
        System.out.println(countTriplets(number));

    }


}


