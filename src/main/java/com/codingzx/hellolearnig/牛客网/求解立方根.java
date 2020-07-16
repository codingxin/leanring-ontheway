package com.codingzx.hellolearnig.牛客网;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author created by zhangxin27695
 * @Classname 求解立方根
 * @Description 216->>6   错误写法： 整数适用
 * 牛顿迭代法。设f(x)=x3-y, 求f(x)=0时的解x，即为y的立方根。
 * 根据牛顿迭代思想，xn+1=xn-f(xn)/f'(xn)即x=x-(x3-y)/(3*x2)=(2*x+y/x/x)/3;
 * @Date 2020-07-16 17:30
 */
public class 求解立方根 {
    public static double getCubeRoot(double input) {
        Set<Double> doubleset = new HashSet<>();
        Double tmp = 2.0;
        int count = 1;
        if (input == 1) {
            return 1.0;
        } else if (input == 2) {
            return 2.0;
        }
        while (input != 1) {
            if (input % tmp == 0) {
                doubleset.add(tmp);
//                System.out.println(tmp);
                input /= tmp;
            } else {
                tmp++;
            }
        }
        for (double a : doubleset) {
            count *= a;
        }
        return count;
    }

    public static double getCubeRoot2(double input) {
        return 1.0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            System.out.println(getCubeRoot(input.nextDouble()));
        }
    }
}
