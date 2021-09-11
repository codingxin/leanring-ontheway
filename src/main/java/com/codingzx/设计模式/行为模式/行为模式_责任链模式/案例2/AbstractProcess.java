package com.codingzx.设计模式.行为模式.行为模式_责任链模式.案例2;

/**
 * @author codingzx
 * @description
 * @date 2021/9/11 15:02
 */
public abstract class AbstractProcess {

    private AbstractProcess next;

    public void setNext(AbstractProcess next) {
        this.next = next;
    }

    public AbstractProcess getNext() {
        return next;
    }

    //处理请求的方法
    public abstract void handleRequest(int LeaveDays);
}
