package com.leetcode;

/**
 * Created by 强 on 2018/8/28.
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class Leetcode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode index = result;
        ListNode first = head, second = null;
        if (first != null) {
            second = first.next;
        }
        while (first != null) {
            if (second != null) {
                ListNode item = new ListNode(second.val);
                index.next = item;
                index = index.next;
            }
            ListNode item = new ListNode(first.val);
            index.next = item;
            index = index.next;
            if (second != null) {
                first = second.next;
                if (first != null) {
                    second = first.next;
                } else {
                    second = null;
                }

            } else {
                first = first.next;
            }
        }
        return result.next;
    }
}
