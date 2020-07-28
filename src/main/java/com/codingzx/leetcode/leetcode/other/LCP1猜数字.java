package com.codingzx.leetcode.leetcode.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author created by zhangxin27695
 * @Classname LCP1猜数字
 * @Description 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
 * <p>
 *  
 * <p>
 * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：guess = [1,2,3], answer = [1,2,3]
 * 输出：3
 * 解释：小A 每次都猜对了。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：guess = [2,2,3], answer = [3,2,1]
 * 输出：1
 * 解释：小A 只猜对了第二次。
 *  
 * <p>
 * 限制：
 * <p>
 * guess的长度 = 3
 * answer的长度 = 3
 * guess的元素取值为 {1, 2, 3} 之一。
 * answer的元素取值为 {1, 2, 3} 之一。
 * @Date 2019-11-18 9:24
 */
public class LCP1猜数字 {

    public static int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3};
        int a3[] = {2, 2, 3};
        HashSet set = new HashSet<>();
        Arrays.stream(a).forEach(e->{
            set.add(e);
        });
        Arrays.stream(a3).forEach(e->{
            set.add(e);
        });
        System.out.println("猜中次数为" + (6 - set.size()));
        System.out.println(game(a, a3));

    }
}
