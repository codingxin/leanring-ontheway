package com.codingzx.leetcode.剑指offer.第一周;

import com.codingzx.leetcode.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author codingzx
 * @description
 * @date 2021/5/29 9:22
 */
public class _06offer反转链表 {
    // 栈
    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = (Integer) stack.pop().val;
        }
        return result;
    }

    // 深度优先
    public static int[] reversePrint2(ListNode head) {
        List<Integer> valueList = new ArrayList<>();
        dfs(valueList, head);
        int[] result = new int[valueList.size()];
//        for (int i = 0; i < valueList.size(); i++) {
//            result[i] = valueList.get(i);
//        }
        int i = 0;
        while (i < valueList.size()) {
            result[i] = valueList.get(i);
            i++;
        }
        return result;
    }

    public static void dfs(List<Integer> valueList, ListNode head) {
        if (head == null) return;
        dfs(valueList, head.next);
        valueList.add((Integer) head.val);

    }


    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(3);
        ListNode t3 = new ListNode(4);
        t1.next = t2;
        t2.next = t3;
        t3.next = null;
        int[] result = reversePrint2(t1);
        for (int i : result) {
            System.out.println(i);
        }
    }


}
