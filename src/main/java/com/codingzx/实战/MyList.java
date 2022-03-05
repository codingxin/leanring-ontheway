package com.codingzx.实战;

import com.codingzx.concurrentThread.aqs.TestReetranReadWriteLock;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author codingzx
 * @description 实现一个针对读多写少场景的有序容器，可以一个一个的插入元素，可以改变这个容器内容的，
 * *      容器的容量限制为固定大小，要求任何时候这个容器都是有序的。
 * *      比如一次插入 [5, 3, 3, 1]，希望顺序是 [1, 3, 3, 5],
 * *      要求: 不借助任何其他有能排序特性的第三方容器
 * <p>
 * 要求：  读多写少
 * 固定大小
 * 有序
 * @date 2022/2/22 20:05
 */
public class MyList {

    private static final long serialVersionUID = 1L;

    public static volatile List<Integer> list = new ArrayList<>(1000);

    public static int COUNT = 1000000;

    private final static ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();

    private final static Lock readLock = lock1.readLock();

    private final static Lock writeLock = lock1.readLock();


    public void put(Integer i) {
        writeLock.lock();
        if (list.size() == COUNT) {
            remove(COUNT);
        }
        try {
            list.add(i);
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
        } catch (Exception e) {

        } finally {
            writeLock.unlock();
        }
    }

    public void remove(Integer i) {
        list.remove(i);
    }

    public void modify(Integer i) {
        list.add(0, i);
    }

    public Integer get(Integer i) {
        readLock.lock();
        try {
            return list.get(i);
        } catch (Exception e) {

        } finally {
            readLock.unlock();
        }
        return null;
    }


    @Override
    public String toString() {
        return "MyList{}" + list;
    }
}
