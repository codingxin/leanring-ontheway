package com.codingzx.deke.尾递归优化;

/**
 * @author codingzx
 * @description
 * @date 2022/2/26 16:56
 */
public class TestDemo {

    public int fact(int n) {
        if (n <= 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public int fact(int n, int r) {
        if (n <= 0) {
            return 1 * r;
        } else {
            return fact(n - 1, r * n);
        }
    }


}
