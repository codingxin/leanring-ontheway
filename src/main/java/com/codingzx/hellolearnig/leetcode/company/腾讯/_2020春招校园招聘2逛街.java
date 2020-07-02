package com.codingzx.hellolearnig.leetcode.company.腾讯;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author created by zhangxin27695
 * @Classname _2020春招校园招聘2逛街
 * @Description 小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
 * 小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
 * <p>
 * 输入描述:
 * 输入第一行将包含一个数字n，代表楼的栋数，接下来的一行将包含n个数字wi(1<=i<=n)，代表每一栋楼的高度。
 * 1<=n<=100000;
 * 1<=wi<=100000;
 * <p>
 * 输出描述:
 * 输出一行，包含空格分割的n个数字vi，分别代表小Q在第i栋楼时能看到的楼的数量。
 * <p>
 * 输入例子1:
 * 6
 * 5 3 8 3 2 5
 * 3 3 6
 * 3 3 5 4 4 4
 * 0 2 -3 2 3 0   3
 * 2 0 -5 0 1 -2  3
 * 3 5 0 5 6 3    5
 * -2 0 -5 0 1 -2 4
 * -3 -1 -6 -1 0 -3
 * <p>
 * 输出例子1:
 * 3 3 5 4 4 4
 * 2 3 4 3 3 4
 * 3 3 5 4 3 4
 * <p>
 * 例子说明1:
 * 当小Q处于位置3时，他可以向前看到位置2,1处的楼，向后看到位置4,6处的楼，加上第3栋楼，共可看到5栋楼。
 * 当小Q处于位置4时，他可以向前看到位置3处的楼，向后看到位置5,6处的楼，加上第4栋楼，共可看到4栋楼。
 * @Date 2020-07-02 10:38
 */
public class _2020春招校园招聘2逛街 {


    public static int[] MaxBuilding(int[] arr) {
        int[] res = new int[arr.length];
        int sum = 2;
        for (int i = 0; i < arr.length; i++) {
            int k = 1;
            for (int j = 0; j < i; ) {
                if (i == 0) {
                    break;
                }
                if (arr[i] - arr[j] >= 0) {
                    if(j!=0&&arr[j] > arr[j - 1]){
                        j++;
                        continue;
                    }
                    j++;
                    ++k;
                } else {
                    ++k;
                    break;
                }
            }
            System.out.println("第" + i + "次前面" + "k为" + k);
            for (int j = i + 1; j < arr.length; ) {
                if (arr[i] - arr[j] >= 0) {
                    if(j!=i+1&&arr[j] < arr[j - 1]){
                        j++;
                        continue;
                    }
                    j++;
                    ++k;
                } else {
                    ++k;
                    break;
                }
            }
//            for (int j = 0; j < arr.length; j++) {
//                if (arr[i] - arr[j] >= 0) {
//                    j++;
//                } else if (i == j) {
//                    continue;
//                } else {
//                    ++k;
//                    if(j>i){
//                        ++k;
//                    }
//                    break;
//                }
//                ++k;
//            }
            System.out.println("第" + i + "次后面" + "k为" + k);

            res[i] = k;
        }
        return res;
    }


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        int n = 6;//scanner.nextInt();
        int[] arr = {5, 3, 8, 3, 2, 5};
        n = 6;
//        for(int i=0;i<n;i++){
//            arr[i]=scanner.nextInt();
//        }
        int[] res = MaxBuilding(arr);
        Arrays.stream(res).forEach(e -> {
            System.out.print(e+ "");
        });
    }
}
