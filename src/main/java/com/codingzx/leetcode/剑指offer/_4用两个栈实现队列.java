package com.codingzx.leetcode.剑指offer;

import java.util.Stack;

/**
 * @author created by zhangxin27695
 * @Classname _5用两个栈实现队列
 * @Description
 * @Date 2020-05-29 11:14
 */
public class _4用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
       stack1.push(node);
    }

    public int pop() {
        // 栈 先进后出
        // 队列 先进先出
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());

            }
        }
        return stack2.pop();
    }
}
