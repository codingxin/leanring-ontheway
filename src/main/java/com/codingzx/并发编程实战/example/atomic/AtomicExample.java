package com.codingzx.并发编程实战.example.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author codingzx
 * @description
 * @date 2021/12/21 20:22
 */
@Slf4j
public class AtomicExample {


    private static AtomicReference<Integer> count = new AtomicReference<>(0);


    public static void main(String[] args) {

        count.compareAndSet(0, 2);
        count.compareAndSet(0, 1);
        count.compareAndSet(1, 3);
        count.compareAndSet(2, 3);
        count.compareAndSet(3, 2);
        log.info("count:{}", count);

    }


}
