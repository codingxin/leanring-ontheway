package com.codingzx.leetcode.company.字节跳动.聪明的编辑;

import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname 聪明的编辑1
 * @Description 链接：https://www.nowcoder.com/questionTerminal/42852fd7045c442192fa89404ab42e92?f=discussion
 * 来源：牛客网
 * <p>
 * 我叫王大锤，是一家出版社的编辑。我负责校对投稿来的英文稿件，这份工作非常烦人，因为每天都要去修正无数的拼写错误。但是，优秀的人总能在平凡的工作中发现真理。我发现一个发现拼写错误的捷径：
 * <p>
 * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 * <p>
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 * <p>
 * 我特喵是个天才！我在蓝翔学过挖掘机和程序设计，按照这个原理写了一个自动校对器，工作效率从此起飞。用不了多久，我就会出任CEO，当上董事长，迎娶白富美，走上人生巅峰，想想都有点小激动呢！
 * ……
 * 万万没想到，我被开除了，临走时老板对我说： “做人做事要兢兢业业、勤勤恳恳、本本分分，人要是行，干一行行一行。一行行行行行；要是不行，干一行不行一行，一行不行行行不行。” 我现在整个人红红火火恍恍惚惚的……
 * <p>
 * 第一行包括一个数字N，表示本次用例包括多少个待校验的字符串。
 * <p>
 * 后面跟随N行，每行为一个待校验的字符串。
 * @Date 2020-03-09 8:29
 */
public class 聪明的编辑3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder(sc.nextLine());
                for (int j = 2; j < sb.length(); j++) {
                    if (sb.charAt(j) == sb.charAt(j - 1) && sb.charAt(j - 1) == sb.charAt(j - 2)) {
                        sb.deleteCharAt(j);
                        j--;
                    } else if (isPattern(j, sb)) {
                        sb.deleteCharAt(j-1);
                        j--;
                    }
                }
                System.out.println(sb);
            }
        }
        sc.close();
    }

    //判断【n-3~n】是否满足 aabb,j代表最后一个B，至少应该等于3
    public static boolean isPattern(int n, StringBuilder sb) {
        if (n < 3) return false;
        return sb.charAt(n - 3) == sb.charAt(n - 2) && sb.charAt(n - 1) == sb.charAt(n);
    }
}
