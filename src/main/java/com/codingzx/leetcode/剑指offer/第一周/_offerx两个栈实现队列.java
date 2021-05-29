package com.codingzx.leetcode.剑指offer.第一周;

import java.util.Stack;

/**
 * @author codingzx
 * @description
 * @date 2021/5/29 10:06
 */
public class _offerx两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        // 栈     后进先出
        // 队列   先进先出
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        _offerx两个栈实现队列 str = new _offerx两个栈实现队列();
        str.push(1);
        str.push(23);
        str.push(34);
        str.push(14);

        System.out.println(str.pop());
        System.out.println(str.pop());
        System.out.println(str.pop());
        System.out.println(str.pop());
        System.out.println(str.pop());

    }


}
