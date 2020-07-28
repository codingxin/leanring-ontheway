package com.codingzx.链表;

import com.codingzx.leetcode.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author created by zhangxin27695
 * @Classname 单向链表每N个节点逆序输出
 * @Description 给出一个链表，每 N 个独立做翻转
 * <p>
 * 案例输入：a->b->c->d->e->f->g 3
 * <p>
 * 案例输出：c->b->a->f->e->d->g
 * @Date 2020-07-28 20:29
 */
public class 单向链表每N个节点逆序输出 {
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode,int count) {
        Stack<Integer> stack = new Stack<>();
        int n = 0;
        while (listNode != null) {
            stack.push((Integer) listNode.val);
            listNode = listNode.next;
            n++;
            if (n == count) {
                while (!stack.isEmpty()) {
                    list.add(stack.pop());
                }
                n = 0;
            }
        }
        return list;
    }

}
