package com.codingzx.链表;

import com.codingzx.leetcode.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author created by zhangxin27695
 * @Classname 单向链表的逆序输出
 * @Description
 * @Date 2020-07-28 20:27
 */
public class 单向链表的逆序输出 {
    ArrayList<Integer> list = new ArrayList<>();

    // 递归
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 递归
        if (listNode != null) {
            this.printListFromTailToHead(listNode.next);
            list.add((Integer) listNode.val);
        }
        return list;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add((Integer) listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
