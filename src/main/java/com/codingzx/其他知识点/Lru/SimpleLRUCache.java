package com.codingzx.其他知识点.Lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author created by zhangxin27695
 * @Classname SimpleLRUCache
 * @Description
 * @Date 2020-07-27 11:01
 */
public class SimpleLRUCache<K, V> {

    private final int MAX_CACHE_SIZE;
    private final float DEFAULT_LOAD_FACTORY = 0.75f;

    LinkedHashMap<K, V> map;

    /**
     * 调用get方法：这个集合就会把元素进行LRU的策略排序，进入源码来看究竟：
     */
    public SimpleLRUCache(int max_cache_size) {
        MAX_CACHE_SIZE = max_cache_size;
        int capacity = (int) Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTORY) + 1; //定义阈值
        /**
         * accessOrder:参数为true时，按照访问顺序，当参数为false时，按照插入顺序，
         */
        map = new LinkedHashMap<K, V>(capacity, DEFAULT_LOAD_FACTORY, true) {
            private static final long serialVersionUID = 1L;

            /**
             *  removeEldestEntry: 可以通过重写这个方法来控制缓存元素的删除，当缓存满了后，
             *  就可以通过返回true删除最久未被使用的元素，达到LRU的要求
             *  重写removeEldestEntry()方法，告诉它什么时候需要删除容器中"最老"的元素
             */
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void remove(K key) {
        map.remove(key);
    }

    public synchronized Set<Map.Entry<K, V>> getAll() {
        return map.entrySet();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            stringBuilder.append(String.format("%s: %s  ", entry.getKey(), entry.getValue()));
        }
        return stringBuilder.toString();
    }
}
