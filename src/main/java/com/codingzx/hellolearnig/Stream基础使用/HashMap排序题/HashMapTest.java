package com.codingzx.hellolearnig.Stream基础使用.HashMap排序题;

import java.util.Collections;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author created by zhangxin27695
 * @Classname HashMapTest
 * @Description
 * @Date 2020-06-14 11:29
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, User> users = new HashMap<>();
        users.put(1, new User("张三", 25));
        users.put(3, new User("李四", 22));
        users.put(2, new User("王五", 28));

        System.out.println(users);
        HashMap<Integer, User> sortHashMap = sortHashMap(users);
        System.out.println(sortHashMap);


    }

    public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map) {
        Set<Map.Entry<Integer, User>> entrySet = map.entrySet();
        List<Map.Entry<Integer, User>> list = new ArrayList<Map.Entry<Integer, User>>(entrySet);

        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });

        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>();

        //将 List 中的数据存储在 LinkedHashMap 中
        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
//        list.stream().map(e -> {
//                    linkedHashMap.put(e.getKey(), e.getValue());
//                    return 1;
//                }
//        ).collect(Collectors.toList());
        return linkedHashMap;
    }
}
