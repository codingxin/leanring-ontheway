package com.codingzx.leetcode.每日一题;

import java.util.Arrays;

/**
 * @author codingzx
 * @description 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/24 19:44
 */
public class _135分发糖果 {

    /**
     * 贪心
     *
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        int[] right = new int[ratings.length];
        int[] left = new int[ratings.length];
        int count = 0;
        Arrays.fill(right, 1);
        Arrays.fill(left, 1);
        // 1. 两次遍历，使每个数组满足最左或者最右最优解
        // 向右依次比较相邻2个数
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                right[i + 1] = right[i] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                left[i - 1] = left[i] + 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            count += Math.max(left[i], right[i]);
        }


        return count;
    }

    public static int candy2(int[] ratings) {
        int length = ratings.length;
        if (length == 1)
            return 1;
        //记录访问到哪个孩子了
        int index = 0;
        //记录总共的糖果
        int total = 0;
        while (index < length - 1) {
            int left = 0;
            //统计递增的长度
            while (index < length - 1 && ratings[index + 1] > ratings[index]) {
                index++;
                left++;
            }
            int right = 0;
            //统计递减的长度
            while (index < length - 1 && ratings[index + 1] < ratings[index]) {
                index++;
                right++;
            }
            //记录顶点的值，也就是左右两边最大的值加1
            int peekCount = Math.max(left, right) + 1;
            //注意这里如果total不等于0要减1，是因为把数组拆分成子数组的时候，低谷的那
            //个会被拆到两个数组中，如果total不等于0，说明之前已经统计过，而下面会再次
            //统计，所以要提前减去。
            if (total != 0)
                total--;
            //当前这个子数组的糖果数量就是前面递增的加上后面递减的然后在加上顶点的。
            total += (1 + left) * left / 2 + (1 + right) * right / 2 + peekCount;
            //如果当前孩子的得分和前一个一样，我们让他降为1
            while (index < length - 1 && ratings[index + 1] == ratings[index]) {
                index++;
                total++;
            }
        }
        return total;


    }


    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy2(ratings));

    }
}
