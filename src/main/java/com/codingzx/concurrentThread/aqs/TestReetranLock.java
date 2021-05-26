package com.codingzx.concurrentThread.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author codingzx
 * @description
 *
 * aqs 内部有两个变量
 * 一个state  保存状态    初始值0
 * 一个当前加锁线程   初始值 null
 *
 * 可重入锁  每重入一次加锁state + 1
 *
 *  线程加锁失败会放入等待队列   默认锁策略为非公平
 *  队列信息： CLH(Craig,Landin,and Hagersten)队列是一个虚拟的双向队列（虚拟的双向队列即不存在队列实例，仅存在结
 *  点之间的关联关系）。AQS是将每条请求共享资源的线程封装成一个CLH锁队列的一个结点（Node）来实现锁
 *  的分配。
 *  与syn区别： 等待可中断 ；  可实现公平锁 ； 可实现选择性通知（锁绑定多个条件）
 *  lock.lockInterruptibly() 中断当前等待的锁
 *
 *
 *
 * @date 2021/5/5 10:54
 */
public class TestReetranLock {

    // 公平锁
    ReentrantLock lock = new ReentrantLock(true);






}
