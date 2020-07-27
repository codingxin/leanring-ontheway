package com.codingzx.leetcode.hello01.java基础;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/9/7
 * @备注 测试Map，总结Map常用便利方法
 **/


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorMap {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Map<String, Double> mymap = new HashMap<String, Double>();
        mymap.put("x1", 1.0);
        System.out.println("第一次赋值： "+mymap.get("x1"));
        mymap.put("x1", 2.0);
        System.out.println("第二次赋值： "+mymap.get("x1"));
        mymap.put("x2", 2.0);
        mymap.put("x3", 3.0);
        // mymap.values();
        System.out.println(mymap.values());// 输出[1.0, 2.0, 3.0]

        for (String str : mymap.keySet()) {
            /** KeySet():
             将Map中所有的键存入到set集合中。因为set具备迭代器。所有可以迭代方式取出所有的键，
             再根据get方法。获取每一个键对应的值。 keySet():迭代后只能通过get()取key
             * 输出 ：1.0
             *       2.0
             *       3.0
             */
            System.out.println(mymap.get(str));
        }
        //
        for (Map.Entry entry : mymap.entrySet()) {
            /** x1 = 1.0
             x2 = 2.0
             x3 = 3.0
             */
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        Iterator it = mymap.entrySet().iterator();
        while (it.hasNext()) {
            /**
             x1 : 1.0
             x2 : 2.0
             x3 : 3.0
             */
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
