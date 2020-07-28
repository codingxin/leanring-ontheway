package com.codingzx.leetcode.leetcode.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author created by zhangxin27695
 * @Classname _771宝石与石头
 * @Description  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
 *  S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 * <p>
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 * @Date 2019-11-18 10:01
 */
public class _771宝石与石头 {
    public static int numJewelsInStones(String J, String S) {
        int count = 0;

        List<Character> stringList=new ArrayList<>();
        for(int i=0;i<S.length(); i++){
            stringList.add(S.charAt(i));
        }
        for(Character ctr:stringList){
            for(int i=0;i<J.length(); i++){
                if(ctr==J.charAt(i)){
                    count++;
                }
            }
        }
        return count;
    }


    public static int numJewelsInStones2(String J, String S) {
        int count = 0;
        Set<Character> hashSet=new HashSet<>();
        for(char j:J.toCharArray()){
            hashSet.add(j);
        }
        for(char s:S.toCharArray()){
            if(hashSet.contains(s)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String str = "z";
        String str2 = "ZZ";
        System.out.println("这个数组" + numJewelsInStones(str, str2));
    }
}
