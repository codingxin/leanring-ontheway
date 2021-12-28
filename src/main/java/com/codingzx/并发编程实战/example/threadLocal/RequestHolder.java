package com.codingzx.并发编程实战.example.threadLocal;

/**
 * @author codingzx
 * @description
 * @date 2021/12/26 14:18
 */
public class RequestHolder {


    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long get() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
