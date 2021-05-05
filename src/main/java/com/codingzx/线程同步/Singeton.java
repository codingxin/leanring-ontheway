package com.codingzx.线程同步;

import lombok.Synchronized;

/**
 * @author codingzx
 * @description
 * 双重校验锁
 * @date 2021/4/26 20:23
 */
public class Singeton {

    private volatile static Singeton singeton;

    private Singeton() {
    }

    public static Singeton getSingeton() {
        if (singeton == null) {
            synchronized (Singeton.class) {
                if (singeton == null) {
                    singeton = new Singeton();
                }
            }
        }
        return singeton;
    }
}