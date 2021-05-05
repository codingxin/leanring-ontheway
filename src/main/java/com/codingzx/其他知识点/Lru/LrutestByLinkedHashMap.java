package com.codingzx.其他知识点.Lru;

/**
 * @author created by zhangxin27695
 * @Classname LrutestByLinkedHashMap
 * @Description
 * @Date 2020-07-27 11:14
 */
public class LrutestByLinkedHashMap {


    public static void main(String[] args) {
        // 阈值为3，再插入就会移除满的
        SimpleLRUCache<String, String> lru = new SimpleLRUCache<>(3);
        lru.put("球员1", "杜兰特");
        lru.put("球员2", "表妹");
        lru.put("球员3", "库里");
        System.out.println("当前元素"+lru);
        lru.get("球员2");  // get 将当前元素移动到链表尾
        System.out.println(lru);
        lru.put("球员4", "一哥");
        lru.put("球员5", "汤姆");
        System.out.println(lru);
        lru.put("球员6", "格林");
        System.out.println(lru);



    }

}
