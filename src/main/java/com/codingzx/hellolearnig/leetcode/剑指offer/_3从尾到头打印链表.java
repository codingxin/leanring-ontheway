//package com.codingzx.hellolearnig.leetcode.剑指offer;
//
//import com.codingzx.hellolearnig.leetcode.leetcode.entity.ListNode;
//
//import java.util.ArrayList;
//import java.util.Stack;
//
///**
// * @author created by zhangxin27695
// * @Classname _3从尾到头打印链表
// * @Description
// * @Date 2020-05-29 10:39
// */
//public class _3从尾到头打印链表 {
//    ArrayList<Integer> list = new ArrayList<>();
//
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        // 递归
//        if (listNode != null) {
//            this.printListFromTailToHead(listNode.next);
//            list.add(listNode.val);
//        }
//        return list;
//    }
//
//    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
//        Stack<Integer> stack = new Stack<>();
//        while (listNode != null) {
//            stack.add(listNode.val);
//            listNode = listNode.next;
//        }
//        while (!stack.isEmpty()) {
//            list.add(stack.pop());
//        }
//        return list;
//    }
//}
