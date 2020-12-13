package com.codingzx;

import com.codingzx.JAVA8高级语法.Stream基础使用.HashMap排序题.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author codingzx
 * @description /**
 * 三个问题选一个作答，时间为一小时
 * 1、给定两个文件，两个文件中记录了商品的交易信息（格式一样，乱序），请找出两个文件中售卖量Top n的商品及其价格
 * 文件格式为：商品名（字符串）\t价格（两位小数的正数），如：
 * 西湖龙井500g	700.00
 * 长城干红750ml	75.00
 * <p>
 * 2、实现一个针对读多写少场景的有序容器，可以一个一个的插入元素，可以改变这个容器内容的，
 * 容器的容量限制为固定大小，要求任何时候这个容器都是有序的。
 * 比如一次插入 [5, 3, 3, 1]，希望顺序是 [1, 3, 3, 5],
 * 要求: 不借助任何其他有能排序特性的第三方容器
 * <p>
 * 3、编程：假设有一个A站点，每次登陆的时候都会记录用户的登陆信息日志，
 * 对象类型是User，有3个字段： userId, userName, loginTime
 * 需求：统计最近10天（每天约10亿条日志）登陆最频繁的10个用户，
 * 排序并输出出这10个用户各登陆多少次
 * 要求：a. 不可直接使用SQL统计，请使用JAVA代码编写
 * b. 功能完备，逻辑正确
 * @date 2020/8/21 20:37
 * 100 0000 0000
 */
public class sortLoginInfo {


    public static void main(String[] args) {
        List<User> list = new ArrayList<>(); // 获取所有list
        List<Integer> userIdlist = list.stream().map(User::getUserId).collect(Collectors.toList());
        Hashtable<Integer, Integer> result = new Hashtable<>(); //userId,出现次数
        for (Integer id : userIdlist) {
            if (result.containsKey(id)) {
                result.put(id, result.get(id) + 1);
            }
            else result.put(id, 1);
        }
        List<Map.Entry<Integer, Integer>> list1 = new ArrayList<Map.Entry<Integer, Integer>>(result.entrySet()); //转换为list
        list1.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
       int i=0;
       for(;i<10;i++){
           System.out.println("用户id"+list1.get(i).getKey()+"出现了"+list1.get(i).getValue()+"次");
       }


    }

}
