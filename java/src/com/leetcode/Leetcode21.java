package com.leetcode;

/**
 * Created by 强 on 2018/8/27.
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class Leetcode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int first = 0;//用于存储result中的第一个变量值
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null && l2 !=null) {
            first = l2.val;
            l2 = l2.next;
        } else if (l2 == null && l1 !=null) {
            first = l1.val;
            l1 = l1.next;
        } else {
            first = l1.val <= l2.val? l1.val : l2.val;
            if (first == l1.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        ListNode result = new ListNode(first);
        ListNode index = result;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                ListNode item = new ListNode(l2.val);
                index.next = item;
                index = index.next;
                l2 = l2.next;
            } else if(l2 == null) {
                ListNode item = new ListNode(l1.val);
                index.next = item;
                index = index.next;
                l1 = l1.next;
            } else if(l1.val <= l2.val) {
                ListNode item = new ListNode(l1.val);
                index.next = item;
                index = index.next;
                l1 = l1.next;
            } else {
                ListNode item = new ListNode(l2.val);
                index.next = item;
                index = index.next;
                l2 = l2.next;
            }
        }
        return result;
    }
}

