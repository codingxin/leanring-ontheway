package com.codingzx.hellolearnig.leetcode.leetcode.中级算法;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author created by zhangxin27695
 * @Classname _64求1到n的和
 * @Description 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020-05-25 19:42
 */
public class _64求1到n的和 {
    public int sumNums(int n) {
        if (n == 1) return 1;
        n += sumNums(n - 1);
        return n;
        /**
         * boolean x = n > 1 && sumNums(n - 1) > 0;
         *         res += n;
         *         return res;
         */
    }
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("a");
        queue.offer("b");
    }


}
