package com.codingzx.设计模式.行为模式.行为模式_责任链模式.案例2;

/**
 * @author codingzx
 * @description
 * 用途 ：
 * 多个对象可以处理一个请求，但具体由哪个对象处理该请求在运行时自动确定。
 * 可动态指定一组对象处理请求，或添加新的处理者。
 * 需要在不明确指定请求处理者的情况下，向多个处理者中的一个提交请求。
 *
 * @date 2021/9/11 15:11
 */
public class TestDemo {

    public static void main(String[] args) {
        AbstractProcess first =new FirstProcess();
        AbstractProcess second = new SecondProcess();
        AbstractProcess three =new ThreeProcess();
        first.setNext(second);
        second.setNext(three);



        first.handleRequest(28);


//        first.handleRequest(5);




    }


}
